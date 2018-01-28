import org.w3c.dom.*;

import java.io.*;

import  org.antlr.v4.runtime.*;
import  org.antlr.v4.runtime.tree.*;
import  org.antlr.v4.runtime.tree.pattern.*;


public class Demo {

    public static void main(String[] args) {
        // Parse xml
        /*String[] xmlArgs = new String[1];
        xmlArgs[0] = "test.xml";
        Document doc = null;
        try {
            doc = DOMEcho.parseXmlToDom(xmlArgs);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Print out the DOM tree
        try {
            OutputStreamWriter outWriter =
                new OutputStreamWriter(System.out, "UTF-8");
            new DOMEcho(new PrintWriter(outWriter, true)).echo(doc);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
        */

        // Parse xquery
        String xquery = "doc(\"j_caesar.xml\")//(ACT,PERSONAE)/TITLE";
        CharStream input = new ANTLRInputStream(xquery);
        XQueryLexer lexer = new XQueryLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        XQueryParser parser = new XQueryParser(tokens);
        ParseTree tree = parser.ap();
        XQueryHelper v = new XQueryHelper();
        v.visit( tree );
//        System.out.println(tree.toStringTree(parser));
//        System.out.println(tree);
//        System.out.println(tree.getChild(0));
//        System.out.println(tree.getChild(1));
        //System.out.println(tree.getChild(1).getPayload().getText());
       /*parser.setBuildParseTree(true);
        
        ParseTreePattern pattern = parser.compileParseTreePattern(xquery, 0);
        ParseTree tree = pattern.getPatternTree();
        System.out.println(tree);
        System.out.println(tree.getChild(0));
        System.out.println(tree.getChild(1));
        System.out.println(tree.getChild(2));
        System.out.println(tree.getPayload());
        System.out.println(tree.getChild(0).getPayload());
        System.out.println(tree.getChild(1).getPayload());
        System.out.println(tree.getChild(2).getPayload());
        System.out.println(tree.getChild(1).getChild(0));
        //System.out.println(parser.getCurrentToken());
*/
    }
}

