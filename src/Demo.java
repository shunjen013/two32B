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
    // Input command arguments
    // args[0]: 0 for xpath, 1 for xquery
    // args[1]: test input file name

    public static final Charset UTF_8 = Charset.forName("UTF-8");

    public static void main(String[] args) {
        String testInput = readFile(args[1], UTF_8);
        System.out.println("Input: \n" + testInput + "\n");
        List<Node> result = null;
        switch(Integer.parseInt(args[0])) {
            case 0:  result = testXPath(testInput);
                     break;
            case 1:  result = testXQuery(testInput);
                     break;
            default: System.out.println("Invalid command");
                     break;
        }
        printResult(result);
    }

    public static List<Node> testXPath(String xpath) {
        CharStream input = new ANTLRInputStream(xpath);
        XQueryLexer lexer = new XQueryLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        XQueryParser parser = new XQueryParser(tokens);
        ParseTree tree = parser.ap();
        XQueryHelper v = new XQueryHelper();
        List<Node> results = v.visit( tree );
        return results;
    }

    public static List<Node> testXQuery(String xquery) {
        // Parse xquery
        CharStream input = new ANTLRInputStream(xquery);
        XQueryLexer lexer = new XQueryLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        XQueryParser parser = new XQueryParser(tokens);
        ParseTree tree = parser.xq();
        XQueryHelper v = new XQueryHelper();
        List<Node> results = v.visit( tree );
        return results;
    }

    public static String readFile(String path, Charset encoding) {
        byte[] encoded = null;
        try {
            encoded = Files.readAllBytes(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(encoded, encoding);
    }

    public static void printResult(List<Node> results) {
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

