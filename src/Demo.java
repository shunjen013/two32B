import org.w3c.dom.*;

import java.io.*;
import java.util.*;

import  org.antlr.v4.runtime.*;
import  org.antlr.v4.runtime.tree.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;


public class Demo {

    public static void main(String[] args) {

        String xquery = null;
        CharStream input = null;
        XQueryLexer lexer = null;
        CommonTokenStream tokens = null;
        XQueryParser parser = null;
        ParseTree tree = null;
        XQueryHelper v = null;
        List<Node> results = null;

        // Parse xpath
        xquery = "doc(\"j_caesar.xml\")//(ACT,PERSONAE)/TITLE";
        System.out.println("XQuery:\n" + xquery);
        input = new ANTLRInputStream(xquery);
        lexer = new XQueryLexer(input);
        tokens = new CommonTokenStream(lexer);
        parser = new XQueryParser(tokens);
        tree = parser.ap();
        v = new XQueryHelper();
        results = v.visit( tree );

        System.out.println("Result:");
        try {
            for (Node n : results) {
                DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                Document doc = dBuilder.newDocument();
                Node nCopy = n.cloneNode(true);
                doc.adoptNode(nCopy);
                doc.appendChild(nCopy);
                System.out.println(getNiceLyFormattedXMLDocument(doc));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Parse xquery
        xquery = "for $a in document(\"test.xml\")//class/student\n" +
                "where some $b in $a//nickname satisfies $b/text() = \"jazz2\"\n" +
                "return $a";
        xquery ="for $a in document(\"j_caesar.xml\")//PERSONAE, $b in $a/PERSONA \n" +
                "where not (($b/text() = \"JULIUS CAESAR\") or ($b/text() = \"Another Poet\") )\n" +
                "return $b";
        System.out.println("XQuery:\n" + xquery);
        input = new ANTLRInputStream(xquery);
        lexer = new XQueryLexer(input);
        tokens = new CommonTokenStream(lexer);
        parser = new XQueryParser(tokens);
        tree = parser.xq();
        v = new XQueryHelper();
        results = v.visit( tree );

        System.out.println("Result:");
        try {
            for (Node n : results) {
                DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                Document doc = dBuilder.newDocument();
                Node nCopy = n.cloneNode(true);
                doc.adoptNode(nCopy);
                doc.appendChild(nCopy);
                System.out.println(getNiceLyFormattedXMLDocument(doc));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static String getNiceLyFormattedXMLDocument(Document doc) throws IOException, TransformerException {
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

        Writer stringWriter = new StringWriter();
        StreamResult streamResult = new StreamResult(stringWriter);
        transformer.transform(new DOMSource(doc), streamResult);
        String result = stringWriter.toString();

        return result;
    }
}

