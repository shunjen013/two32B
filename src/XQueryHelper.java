
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;
import java.util.*;

public class XQueryHelper extends XQueryBaseVisitor <List<Node>> {
    List<Node> currNodes = new ArrayList<Node>();

    // [doc(filename)/rp]_A -> [rp]_R(root(filename))
    public List<Node> visitSlash(XQueryParser.SlashContext ctx) {
        System.out.println("Enter Slash");
        System.out.println(ctx.fileName().getText());

        // read xml and get dom root node
        Document doc = getDomRootNode(ctx.fileName().getText());
        currNodes.add(doc);
        visit(ctx.rp());
        return currNodes;
    }

    // [doc(filename)//rp]_A -> [.//rp]_R(root(filename))
    public List<Node> visitDSlash(XQueryParser.DSlashContext ctx) {
        System.out.println("Enter double slash");
        System.out.println(ctx.fileName().getText());

        // read xml and get dom root node
        Document doc = getDomRootNode(ctx.fileName().getText());
        return visit(ctx.rp());

    }

    public List<Node> visitParen(XQueryParser.ParenContext ctx) {
        System.out.println("Enter Rp Paren");
        return visitChildren(ctx);
    }
    public List<Node> visitStar(XQueryParser.StarContext ctx) {
        System.out.println("Star");
        return visitChildren(ctx);
    }
    public List<Node> visitFilterRP(XQueryParser.FilterRPContext ctx) {
        System.out.println("Enter Rp FilterRP");
        return visitChildren(ctx);
    }

    public List<Node> visitCommaRP(XQueryParser.CommaRPContext ctx) {
        System.out.println("Enter Rp CommaRp");
        return visitChildren(ctx);
    }

    public List<Node> visitDot(XQueryParser.DotContext ctx) {
        System.out.println("Enter Rp Dot");
        return visitChildren(ctx);
    }
    public List<Node> visitTag(XQueryParser.TagContext ctx) {
        System.out.println("Enter Rp Tag: "+ctx.getText());
        String tagName = ctx.getText();
        List<Node> ret = new ArrayList<>();
        for(Node t : currNodes) {
            List<Node> tcList = children(t);
            for(Node tc : tcList) {
                if(tc.getNodeName().equals(tagName)) {
                    ret.add(tc);
                }
            }
        }
        currNodes = ret;
        return ret;
    }
    public List<Node> visitDdot(XQueryParser.DdotContext ctx) {
        System.out.println("Enter Rp Ddot");
        return visitChildren(ctx);
    }
    public List<Node> visitText(XQueryParser.TextContext ctx) {
        System.out.println("Enter Rp Text");
        return visitChildren(ctx);
    }
    public List<Node> visitAttribute(XQueryParser.AttributeContext ctx) {
        System.out.println("Enter Rp Attr");
        return visitChildren(ctx);
    }
    public List<Node> visitDslashRP(XQueryParser.DslashRPContext ctx) {
        System.out.println("Enter Rp Dslash");
        return visitChildren(ctx);
    }
    public List<Node> visitSlashRP(XQueryParser.SlashRPContext ctx) {
        System.out.println("Enter Rp Slash");
        return visitChildren(ctx);
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

    public List<Node> relativePath(XQueryParser.RpContext rpx, Node n) {
        List<Node> nList = new ArrayList<Node>();
        return nList;
    }
}