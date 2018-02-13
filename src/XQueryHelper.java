
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;
import java.util.*;

public class XQueryHelper extends XQueryBaseVisitor <List<Node>> {
    Map<String, Node> context = new HashMap<>();
    List<Node> currNodes = new ArrayList<>();
    boolean currFilter = false;
    boolean currCond = false;

    // Ap functions
    // [doc(filename)/rp]_A -> [rp]_R(root(filename))
    public List<Node> visitSlash(XQueryParser.SlashContext ctx) {
        System.out.println("Enter Ap Slash");
        System.out.println(ctx.fileName().getText());

        // read xml and get dom root node
        Document doc = getDomRootNode(ctx.fileName().getText());
        currNodes.add(doc);
        visit(ctx.rp());
        return currNodes;
    }

    // [doc(filename)//rp]_A -> [.//rp]_R(root(filename))
    public List<Node> visitDSlash(XQueryParser.DSlashContext ctx) {
        System.out.println("Enter Ap Dslash");
        System.out.println(ctx.fileName().getText());

        // read xml and get dom root node
        Document doc = getDomRootNode(ctx.fileName().getText());
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
        System.out.println("Enter Rp Paren");
        visit(ctx.rp());
        return currNodes;
    }

    public List<Node> visitStar(XQueryParser.StarContext ctx) {
        System.out.println("Star");
        List<Node> ret = new ArrayList<>();
        for(Node t : currNodes) {
            ret.addAll(children(t));
        }
        currNodes = ret;
        return currNodes;
    }

    public List<Node> visitFilterRP(XQueryParser.FilterRPContext ctx) {
        System.out.println("Enter Rp FilterRP");
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
        System.out.println("Enter Rp CommaRp");
        List<Node> currNodesCopy = new ArrayList<>(currNodes);
        visit(ctx.rp(1));
        List<Node> prevResult = new ArrayList<>(currNodes);
        currNodes = currNodesCopy;
        visit(ctx.rp(0));
        currNodes.addAll(prevResult);
        return currNodes;
    }

    public List<Node> visitDot(XQueryParser.DotContext ctx) {
        System.out.println("Enter Rp Dot");
        return currNodes;
    }

    public List<Node> visitTag(XQueryParser.TagContext ctx) {
        System.out.println("Enter Rp Tag: "+ctx.getText());
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
        System.out.println("Enter Rp Ddot");
        List<Node> ret = new ArrayList<>();
        for(Node t : currNodes) {
            ret.add(parent(t));
        }
        currNodes = ret;
        return currNodes;
    }

    public List<Node> visitText(XQueryParser.TextContext ctx) {
        System.out.println("Enter Rp Text");
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
        System.out.println("Enter Rp Dslash");
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
        System.out.println("Enter Rp Slash");
        //System.err.println(currNodes);
        visit(ctx.rp(0));
        //System.err.println(currNodes);
        visit(ctx.rp(1));
        currNodes = unique(currNodes);
        return currNodes;
    }

    // Filter functions
    public List<Node> visitRpFilter(XQueryParser.RpFilterContext ctx) {
        System.out.println("Enter Filter Rp");
        visit(ctx.rp());
        currFilter = currNodes.size() != 0;
        return currNodes;
    }

    public List<Node> visitEqFilter(XQueryParser.EqFilterContext ctx) {
        System.out.println("Enter Filter Eq");
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
        System.out.println("Enter Filter Is");
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
        System.out.println("Enter Filter Not");
        visit(ctx.filter());
        currFilter = !currFilter;
        return currNodes;
    }

    public List<Node> visitAndFilter(XQueryParser.AndFilterContext ctx) {
        System.out.println("Enter Filter And");
        List<Node> currNodesCopy = new ArrayList<>(currNodes);
        visit(ctx.filter(0));
        boolean prevResult = currFilter;
        currNodes = currNodesCopy;
        visit(ctx.filter(1));
        currFilter &= prevResult;
        return currNodes;
    }

    public List<Node> visitOrFilter(XQueryParser.OrFilterContext ctx) {
        System.out.println("Enter Filter Or");
        List<Node> currNodesCopy = new ArrayList<>(currNodes);
        visit(ctx.filter(0));
        boolean prevResult = currFilter;
        currNodes = currNodesCopy;
        visit(ctx.filter(1));
        currFilter |= prevResult;
        return currNodes;
    }

    public List<Node> visitParenFilter(XQueryParser.ParenFilterContext ctx) {
        System.out.println("Enter Filter Paren");
        visit(ctx.filter());
        return currNodes;
    }

    // Xq functions
    public List<Node> visitStrXQ(XQueryParser.StrXQContext ctx) {
        System.out.println("Enter Xq Str");
        List<Node> ret = new ArrayList<>();
        ret.add(makeText(ctx.stringConstant().getText()));
        currNodes = ret;
        return currNodes;
    }

    public List<Node> visitSlashXQ(XQueryParser.SlashXQContext ctx) {
        System.out.println("Enter Xq Slash");
        visit(ctx.xq());
        visit(ctx.rp());
        currNodes = unique(currNodes);
        return currNodes;
    }

    public List<Node> visitTagXQ(XQueryParser.TagXQContext ctx) {
        System.out.println("Enter Xq Tag");
        visit(ctx.xq());
        List<Node> ret = new ArrayList<>();
        ret.add(makeElem(ctx.tagName(0).getText(), currNodes));
        currNodes = ret;
        return currNodes;
    }

    public List<Node> visitFlwrXQ(XQueryParser.FlwrXQContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    public List<Node> visitApXQ(XQueryParser.ApXQContext ctx) {
        System.out.println("Enter Xq Ap");
        visit(ctx.ap());
        return currNodes;
    }

    public List<Node> visitParenXQ(XQueryParser.ParenXQContext ctx) {
        System.out.println("Enter Xq Paren");
        visit(ctx.xq());
        return currNodes;
    }

    public List<Node> visitLetXQ(XQueryParser.LetXQContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    public List<Node> visitDslashXQ(XQueryParser.DslashXQContext ctx) {
        System.out.println("Enter Xq Dslash");
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
        System.out.println("Enter Xq Comma");
        List<Node> currNodesCopy = new ArrayList<>(currNodes);
        visit(ctx.xq(1));
        List<Node> prevResult = new ArrayList<>(currNodes);
        currNodes = currNodesCopy;
        visit(ctx.xq(0));
        currNodes.addAll(prevResult);
        return currNodes;
    }

    public List<Node> visitVarXQ(XQueryParser.VarXQContext ctx) {
        System.out.println("Enter Xq Var");
        List<Node> ret = new ArrayList<>();
        ret.add(context.get(ctx.var().getText()));
        currNodes = ret;
        return currNodes;
    }

    public List<Node> visitForCl(XQueryParser.ForClContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    public List<Node> visitLetCl(XQueryParser.LetClContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    public List<Node> visitWhereCl(XQueryParser.WhereClContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    public List<Node> visitRetCl(XQueryParser.RetClContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    public List<Node> visitOrCond(XQueryParser.OrCondContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    public List<Node> visitEmpCond(XQueryParser.EmpCondContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    public List<Node> visitAndCond(XQueryParser.AndCondContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    public List<Node> visitSomeCond(XQueryParser.SomeCondContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    public List<Node> visitParenCond(XQueryParser.ParenCondContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    public List<Node> visitIsCond(XQueryParser.IsCondContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    public List<Node> visitEqCond(XQueryParser.EqCondContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    public List<Node> visitNotCond(XQueryParser.NotCondContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */

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
        System.out.println("Root Element : " + doc.getDocumentElement().getNodeName());
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
            Element rootElement = doc.createElement(t);
            doc.appendChild(rootElement);
            for (Node n: l) {
                rootElement.appendChild(n.cloneNode(true));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doc.getDocumentElement();
    }

    public Node makeText(String s) {
        Document doc = null;
        try {
            DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            doc = dBuilder.newDocument();
            Text rootElement = doc.createTextNode(s);
            doc.appendChild(rootElement);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doc.getDocumentElement();
    }

    public Map<String, Node> extendContext(String k, Node v) {
        Map<String, Node> newContext = new HashMap<String, Node>(context);
        newContext.put(k, v);
        return newContext;
    }
}