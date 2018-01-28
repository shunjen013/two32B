import org.w3c.dom.*;

import java.io.*;
import java.util.*;

import  org.antlr.v4.runtime.*;
import  org.antlr.v4.runtime.tree.*;
import  org.antlr.v4.runtime.tree.pattern.*;


public class Demo {

    public static void main(String[] args) {
        // Parse xquery
        String xquery = "doc(\"j_caesar.xml\")/(ACT,PERSONAE)/TITLE";
        System.out.println(xquery);
        CharStream input = new ANTLRInputStream(xquery);
        XQueryLexer lexer = new XQueryLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        XQueryParser parser = new XQueryParser(tokens);
        ParseTree tree = parser.ap();
        XQueryHelper v = new XQueryHelper();
        List<Node> results = v.visit( tree );


        // Print out the DOM result
//        try {
//            OutputStreamWriter outWriter =
//                    new OutputStreamWriter(System.out, "UTF-8");
//            for(int i=0; i<results.size(); i++) {
//                new DOMEcho(new PrintWriter(outWriter, true)).echo(results.get(i));
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        System.out.println(tree.toStringTree(parser));
//        System.out.println(tree);R
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

