import org.w3c.dom.*;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
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

    public static final Charset UTF_8 = Charset.forName("UTF-8");

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
        /*
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
        */

        // Read input file
        try {
            xquery = readFile(args[0], UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Parse xquery
        input = new ANTLRInputStream(xquery);
        lexer = new XQueryLexer(input);
        tokens = new CommonTokenStream(lexer);
        parser = new XQueryParser(tokens);
        tree = parser.xq();
        v = new XQueryHelper();
        results = v.visit( tree );

        // Print result
        System.out.println("Input Query: \n" + xquery);
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

    public static String readFile(String path, Charset encoding)
            throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }
}

