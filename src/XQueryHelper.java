
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.*;
import java.util.*;

public class XQueryHelper extends XQueryBaseVisitor <List<Node>> {
    Map<String, Node> context = new HashMap<>();    // Context is actively recovered in functions
                                                    // that modifies it (Flwr Xq, Let Xq, Some Cond)
    List<Node> currNodes = new ArrayList<>();       // Other global variables and context in other situations
    boolean currFilter = false;                     // are recovered passively only if the function needs to
    boolean currCond = false;                       // use their original version later in the same function
    XQueryParser.FlwrXQContext flwrXqCtx = null;

    // Ap functions
    // [doc(filename)/rp]_A -> [rp]_R(root(filename))
    public List<Node> visitSlash(XQueryParser.SlashContext ctx) {
        //System.err.println("Enter Ap Slash");
        //System.err.println(removeHeadTail(ctx.fileName().getText()));

        // read xml and get dom root node
        Document doc = getDomRootNode(removeHeadTail(ctx.fileName().getText()));
        currNodes.add(doc);
        visit(ctx.rp());
        return currNodes;
    }

    // [doc(filename)//rp]_A -> [.//rp]_R(root(filename))
    public List<Node> visitDSlash(XQueryParser.DSlashContext ctx) {
        //System.err.println("Enter Ap Dslash");
        //System.err.println(removeHeadTail(ctx.fileName().getText()));

        // read xml and get dom root node
        Document doc = getDomRootNode(removeHeadTail(ctx.fileName().getText()));
        currNodes.add(doc);
        int idx = 0;
        while (idx < currNodes.size()) {
            currNodes.addAll(new ArrayList<>(children(currNodes.get(idx))));
            idx ++;
        }
        visit(ctx.rp());
        return currNodes;
    }

    // Rp functions
    public List<Node> visitParen(XQueryParser.ParenContext ctx) {
        //System.err.println("Enter Rp Paren");
        visit(ctx.rp());
        return currNodes;
    }

    public List<Node> visitStar(XQueryParser.StarContext ctx) {
        //System.err.println("Star");
        List<Node> ret = new ArrayList<>();
        for(Node t : currNodes) {
            ret.addAll(children(t));
        }
        currNodes = ret;
        return currNodes;
    }

    public List<Node> visitFilterRP(XQueryParser.FilterRPContext ctx) {
        //System.err.println("Enter Rp FilterRP");
        visit(ctx.rp());
        List<Node> currNodesCopy = new ArrayList<>(currNodes);
        List<Node> ret = new ArrayList<>();
        for (int i = 0; i < currNodesCopy.size(); i ++) {
            currNodes = new ArrayList<>(currNodesCopy.subList(i, i + 1));
            visit(ctx.filter());
            if (currFilter) {
                ret.add(currNodesCopy.get(i));
            }
        }
        currNodes = ret;
        return currNodes;
    }

    public List<Node> visitCommaRP(XQueryParser.CommaRPContext ctx) {
        //System.err.println("Enter Rp CommaRp");
        List<Node> currNodesCopy = new ArrayList<>(currNodes);
        visit(ctx.rp(1));
        List<Node> prevResult = new ArrayList<>(currNodes);
        currNodes = currNodesCopy;
        visit(ctx.rp(0));
        currNodes.addAll(prevResult);
        return currNodes;
    }

    public List<Node> visitDot(XQueryParser.DotContext ctx) {
        //System.err.println("Enter Rp Dot");
        return currNodes;
    }

    public List<Node> visitTag(XQueryParser.TagContext ctx) {
        //System.err.println("Enter Rp Tag: "+ctx.getText());
        String tagName = ctx.tagName().getText(); // not sure, haven't tested
        //System.err.println(tagName);
        List<Node> ret = new ArrayList<>();
        for(Node t : currNodes) {
            List<Node> tcList = children(t);
            for(Node tc : tcList) {
                //System.err.println(tc.getNodeName());
                if(tc.getNodeName().equals(tagName)) {
                    ret.add(tc);
                }
            }
        }
        currNodes = ret;
        return currNodes;
    }

    public List<Node> visitDdot(XQueryParser.DdotContext ctx) {
        //System.err.println("Enter Rp Ddot");
        List<Node> ret = new ArrayList<>();
        for(Node t : currNodes) {
            ret.add(parent(t));
        }
        currNodes = ret;
        return currNodes;
    }

    public List<Node> visitText(XQueryParser.TextContext ctx) {
        //System.err.println("Enter Rp Text");
        List<Node> ret = new ArrayList<>();
        for(Node t : currNodes) {
            ret.addAll(txt(t));
        }
        currNodes = ret;
        return currNodes;
    }

    public List<Node> visitAttribute(XQueryParser.AttributeContext ctx) {
        List<Node> ret = new ArrayList<>();
        for(Node t : currNodes) {
            if (attrib(t, ctx.attName().getText()) != null) {
                ret.add(attrib(t, ctx.attName().getText()));
            }
        }
        currNodes = ret;
        return currNodes;
    }

    public List<Node> visitDslashRP(XQueryParser.DslashRPContext ctx) {
        //System.err.println("Enter Rp Dslash");
        visit(ctx.rp(0));
        int idx = 0;
        while (idx < currNodes.size()) {
            currNodes.addAll(new ArrayList<>(children(currNodes.get(idx))));
            idx ++;
        }
        visit(ctx.rp(1));
        currNodes = unique(currNodes);
        return currNodes;
    }

    public List<Node> visitSlashRP(XQueryParser.SlashRPContext ctx) {
        //System.err.println("Enter Rp Slash");
        visit(ctx.rp(0));
        visit(ctx.rp(1));
        currNodes = unique(currNodes);
        return currNodes;
    }

    // Filter functions
    public List<Node> visitRpFilter(XQueryParser.RpFilterContext ctx) {
        //System.err.println("Enter Filter Rp");
        visit(ctx.rp());
        currFilter = currNodes.size() != 0;
        return currNodes;
    }

    public List<Node> visitEqFilter(XQueryParser.EqFilterContext ctx) {
        //System.err.println("Enter Filter Eq");
        List<Node> currNodesCopy = new ArrayList<>(currNodes);
        visit(ctx.rp(0));
        List<Node> prevResult = new ArrayList<>(currNodes);
        currNodes = currNodesCopy;
        visit(ctx.rp(1));
        for (Node t1: prevResult) {
            for (Node t2: currNodes) {
                if (t1.isEqualNode(t2)) {
                    currFilter = true;
                    return currNodes;
                }
            }
        }
        currFilter = false;
        return currNodes;
    }

    public List<Node> visitIsFilter(XQueryParser.IsFilterContext ctx) {
        //System.err.println("Enter Filter Is");
        List<Node> currNodesCopy = new ArrayList<>(currNodes);
        visit(ctx.rp(0));
        List<Node> prevResult = new ArrayList<>(currNodes);
        currNodes = currNodesCopy;
        visit(ctx.rp(1));
        for (Node t1: prevResult) {
            for (Node t2: currNodes) {
                if (t1.isSameNode(t2)) {
                    currFilter = true;
                    return currNodes;
                }
            }
        }
        currFilter = false;
        return currNodes;
    }

    public List<Node> visitNotFilter(XQueryParser.NotFilterContext ctx) {
        //System.err.println("Enter Filter Not");
        visit(ctx.filter());
        currFilter = !currFilter;
        return currNodes;
    }

    public List<Node> visitAndFilter(XQueryParser.AndFilterContext ctx) {
        //System.err.println("Enter Filter And");
        List<Node> currNodesCopy = new ArrayList<>(currNodes);
        visit(ctx.filter(0));
        boolean prevResult = currFilter;
        currNodes = currNodesCopy;
        visit(ctx.filter(1));
        currFilter &= prevResult;
        return currNodes;
    }

    public List<Node> visitOrFilter(XQueryParser.OrFilterContext ctx) {
        //System.err.println("Enter Filter Or");
        List<Node> currNodesCopy = new ArrayList<>(currNodes);
        visit(ctx.filter(0));
        boolean prevResult = currFilter;
        currNodes = currNodesCopy;
        visit(ctx.filter(1));
        currFilter |= prevResult;
        return currNodes;
    }

    public List<Node> visitParenFilter(XQueryParser.ParenFilterContext ctx) {
        //System.err.println("Enter Filter Paren");
        visit(ctx.filter());
        return currNodes;
    }

    // Xq functions
    public List<Node> visitStrXQ(XQueryParser.StrXQContext ctx) {
        //System.err.println("Enter Xq Str");
        List<Node> ret = new ArrayList<>();
        ret.add(makeText(removeHeadTail(ctx.stringConstant().STRINGCONSTANT().getText())));
        currNodes = ret;
        return currNodes;
    }

    public List<Node> visitSlashXQ(XQueryParser.SlashXQContext ctx) {
        //System.err.println("Enter Xq Slash");
        visit(ctx.xq());
        visit(ctx.rp());
        currNodes = unique(currNodes);
        return currNodes;
    }

    public List<Node> visitTagXQ(XQueryParser.TagXQContext ctx) {
        //System.err.println("Enter Xq Tag");
        visit(ctx.xq());
        List<Node> ret = new ArrayList<>();
        ret.add(makeElem(ctx.tagName(0).STRING().getText(), currNodes));
        currNodes = ret;
        return currNodes;
    }

    public List<Node> visitFlwrXQ(XQueryParser.FlwrXQContext ctx) {
        //System.err.println("Enter Xq Flwr");
        Map<String, Node> contextCopy = context;
        flwrXqCtx  = ctx;
        visit(ctx.forClause());
        context = contextCopy;
        return currNodes;
    }

    public List<Node> visitApXQ(XQueryParser.ApXQContext ctx) {
        //System.err.println("Enter Xq Ap");
        visit(ctx.ap());
        return currNodes;
    }

    public List<Node> visitParenXQ(XQueryParser.ParenXQContext ctx) {
        //System.err.println("Enter Xq Paren");
        visit(ctx.xq());
        return currNodes;
    }

    public List<Node> visitLetXQ(XQueryParser.LetXQContext ctx) {
        //System.err.println("Enter Xq Let");
        Map<String, Node> contextCopy = context;
        visit(ctx.letClause());
        visit(ctx.xq());
        context = contextCopy;
        return currNodes;
    }

    public List<Node> visitDslashXQ(XQueryParser.DslashXQContext ctx) {
        //System.err.println("Enter Xq Dslash");
        visit(ctx.xq());
        int idx = 0;
        while (idx < currNodes.size()) {
            currNodes.addAll(new ArrayList<>(children(currNodes.get(idx))));
            idx ++;
        }
        visit(ctx.rp());
        currNodes = unique(currNodes);
        return currNodes;
    }

    public List<Node> visitCommaXQ(XQueryParser.CommaXQContext ctx) {
        //System.err.println("Enter Xq Comma");
        List<Node> currNodesCopy = new ArrayList<>(currNodes);
        visit(ctx.xq(1));
        List<Node> prevResult = new ArrayList<>(currNodes);
        currNodes = currNodesCopy;
        visit(ctx.xq(0));
        currNodes.addAll(prevResult);
        return currNodes;
    }

    public List<Node> visitVarXQ(XQueryParser.VarXQContext ctx) {
        //System.err.println("Enter Xq Var");
        List<Node> ret = new ArrayList<>();
        ret.add(context.get(ctx.var().getText()));
        currNodes = ret;
        return currNodes;
    }

    //Cl functions

    public List<Node> visitForCl(XQueryParser.ForClContext ctx) {
        //System.err.println("enter Cl For");
        int varNum = ctx.getChildCount() / 4;
        List<Node> ret = new ArrayList<>();
        forClHelper(ctx, 0, varNum, ret);
        currNodes = ret;
        return currNodes;
    }

    public void forClHelper(XQueryParser.ForClContext ctx, int idx, int varNum, List<Node> ret) {
        XQueryParser.FlwrXQContext flwrXQContextCopy = flwrXqCtx;
        if (idx == varNum) {
            if (flwrXqCtx.letClause() != null) {
                visit(flwrXqCtx.letClause());
            }
            currCond = true;
            flwrXqCtx = flwrXQContextCopy;
            if (flwrXqCtx.whereClause() != null) {
                visit(flwrXqCtx.whereClause());
            }
            if (currCond) {
                flwrXqCtx = flwrXQContextCopy;
                visit(flwrXqCtx.returnClause());
                ret.addAll(currNodes);
            }
        }
        else {
            visit(ctx.xq(idx));
            List<Node> currNodesCopy = new ArrayList<>(currNodes);
            Map<String, Node> contextCopy = context;
            for (Node n: currNodesCopy) {
                context = contextCopy;
                context = extendContext(ctx.var(idx).getText(), n);
                flwrXqCtx = flwrXQContextCopy;
                forClHelper(ctx, idx + 1, varNum, ret);
            }
        }
    }

    public List<Node> visitLetCl(XQueryParser.LetClContext ctx) {
        //System.err.println("Enter Cl Let");
        int varNum = ctx.var().size(); //ctx.getChildCount() / 4;
        for (int i = 0; i < varNum; i ++) {
            visit(ctx.xq(i));
            context = extendContext(ctx.var(i).getText(), currNodes.get(0));
        }
        return currNodes;
    }

    public List<Node> visitWhereCl(XQueryParser.WhereClContext ctx) {
        //System.err.println("Enter Cl Where");
        visit(ctx.cond());
        return currNodes;
    }

    public List<Node> visitRetCl(XQueryParser.RetClContext ctx) {
        //System.err.println("Enter Cl Ret");
        visit(ctx.xq());
        return currNodes;
    }


    // Cond functions
    public List<Node> visitOrCond(XQueryParser.OrCondContext ctx) {
        //System.err.println("Enter Cond Or");
        List<Node> currNodesCopy = new ArrayList<>(currNodes);
        visit(ctx.cond(0));
        boolean prevResult = currCond;
        currNodes = currNodesCopy;
        visit(ctx.cond(1));
        currCond |= prevResult;
        return currNodes;
    }

    public List<Node> visitEmpCond(XQueryParser.EmpCondContext ctx) {
        //System.err.println("Enter Cond Empty");
        visit(ctx.xq());
        currCond = currNodes.size() == 0;
        return currNodes;
    }

    public List<Node> visitAndCond(XQueryParser.AndCondContext ctx) {
        //System.err.println("Enter Cond And");
        List<Node> currNodesCopy = new ArrayList<>(currNodes);
        visit(ctx.cond(0));
        boolean prevResult = currCond;
        currNodes = currNodesCopy;
        visit(ctx.cond(1));
        currCond &= prevResult;
        return currNodes;
    }

    public List<Node> visitSomeCond(XQueryParser.SomeCondContext ctx) {
        //System.err.println("Enter Cond Some");
        Map<String, Node> contextCopy = context;
        int varNum = ctx.var().size(); //ctx.getChildCount() - 2) / 4;
        someCondHelper(ctx, 0, varNum);
        context = contextCopy;
        return currNodes;
    }

    public boolean someCondHelper(XQueryParser.SomeCondContext ctx, int idx, int varNum) {
        if (idx == varNum) {
            visit(ctx.cond());
            if (currCond)
                return true;
            else
                return false;
        }
        else {
            visit(ctx.xq(idx));
            List<Node> currNodesCopy = new ArrayList<>(currNodes);
            Map<String, Node> contextCopy = context;
            for (Node n: currNodesCopy) {
                context = extendContext(ctx.var(idx).getText(), n);
                if (someCondHelper(ctx, idx + 1, varNum))
                    return true;
                else
                    context = contextCopy;
            }
            return false;
        }
    }

    public List<Node> visitParenCond(XQueryParser.ParenCondContext ctx) {
        //System.err.println("Enter Cond Paren");
        visit(ctx.cond());
        return currNodes;
    }

    public List<Node> visitIsCond(XQueryParser.IsCondContext ctx) {
        //System.err.println("Enter Cond Is");
        List<Node> currNodesCopy = new ArrayList<>(currNodes);
        visit(ctx.xq(0));
        List<Node> prevResult = new ArrayList<>(currNodes);
        currNodes = currNodesCopy;
        visit(ctx.xq(1));
        for (Node t1: prevResult) {
            for (Node t2: currNodes) {
                if (t1.isSameNode(t2)) {
                    currCond = true;
                    return currNodes;
                }
            }
        }
        currCond = false;
        return currNodes;
    }

    public List<Node> visitEqCond(XQueryParser.EqCondContext ctx) {
        //System.err.println("Enter Cond Eq");
        List<Node> currNodesCopy = new ArrayList<>(currNodes);
        visit(ctx.xq(0));
        List<Node> prevResult = new ArrayList<>(currNodes);
        currNodes = currNodesCopy;
        visit(ctx.xq(1));
        for (Node t1: prevResult) {
            for (Node t2: currNodes) {
                if (t1.isEqualNode(t2)) {
                    currCond = true;
                    return currNodes;
                }
            }
        }
        currCond = false;
        return currNodes;
    }

    public List<Node> visitNotCond(XQueryParser.NotCondContext ctx) {
        //System.err.println("Enter Cond Not");
        visit(ctx.cond());
        currCond = !currCond;
        return currNodes;
    }

    // Helper functions
    public Document getDomRootNode(String fileName) {
        // read xml and get dom root node
        Document doc = null;
        try {
            DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            doc = dBuilder.parse(fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.err.println("Root Element : " + doc.getDocumentElement().getNodeName());
        return doc;
    }

    public List<Node> children(Node n) {
        List<Node> cList = new ArrayList<>();
        for(int i=0; i<n.getChildNodes().getLength(); i++) {
            cList.add(n.getChildNodes().item(i));
        }
        return cList;
    }

    public Node parent(Node n) {
        return n.getParentNode();
    }

    public List<Node> txt(Node n) {
        List<Node> tList = new ArrayList<>();
        for(int i=0; i<n.getChildNodes().getLength(); i++) {
            if (n.getChildNodes().item(i).getNodeType() == Node.TEXT_NODE) {
                tList.add(n.getChildNodes().item(i));
            }
        }
        return tList;
    }

    public Node attrib(Node n, String attName) {
        return n.getAttributes().getNamedItem(attName);
    }

    public List<Node> unique(List<Node> originalList) {
        List<Node> ret = new ArrayList<>();
        HashSet<Node> set = new HashSet<>();
        for(Node t: originalList) {
            if(set.add(t)) {
                ret.add(t);
            }
        }
        return ret;
    }

    public Node makeElem(String t, List<Node> l) {
        Document doc = null;
        try {
            DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            doc = dBuilder.newDocument();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Element rootElement = doc.createElement(t);
        doc.appendChild(rootElement);
        for (Node n: l) {
            Node nCopy = n.cloneNode(true);
            doc.adoptNode(nCopy);
            rootElement.appendChild(nCopy);
        }
        return rootElement;
    }

    public Node makeText(String s) {
        Document doc = null;
        try {
            DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            doc = dBuilder.newDocument();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doc.createTextNode(s);
    }

    public Map<String, Node> extendContext(String k, Node v) {
        Map<String, Node> newContext = new HashMap<>(context);
        newContext.put(k, v);
        return newContext;
    }

    public String removeHeadTail(String s) {
        return s.substring(1, s.length() - 1);
    }
}