
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;
import java.util.*;

public class XQueryHelper extends  XQueryBaseVisitor <Integer> {

    List<Node> nodes = new ArrayList<Node>();

    public Integer visitSlash(XQueryParser.SlashContext ctx) {
        System.out.println("Enter Slash");
        System.out.println(ctx.fileName().getText());
        return 0;
    }

    // [doc(filename)//rp]_A -> [.//rp]_R(root(filename))
    public Integer visitDSlash(XQueryParser.DSlashContext ctx) {
        System.out.println("Enter double slash");
        System.out.println(ctx.fileName().getText());

        // read xml and get dom root node
        Document doc = null;
        String fName = ctx.fileName().getText();
        try {
            DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            doc = dBuilder.parse(fName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Root Element : " + doc.getDocumentElement().getNodeName());

        XQueryParser.RpContext rpx = ctx.rp();
        List<Node> tmp = relativePath(rpx, doc);

        return 0;
    }


    // Helper functions
    public List<Node> relativePath(XQueryParser.RpContext rpx, Node n) {
        List<Node> nList = new ArrayList<Node>();
        return nList;
    }
}