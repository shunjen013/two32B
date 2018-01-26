import org.w3c.dom.*;

import java.io.*;

public class Demo {

    public static void main(String[] args) {
        String[] xmlArgs = new String[1];
        xmlArgs[0] = "../test.xml";
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
    }
}

