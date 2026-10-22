
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class Exercice1 {

    public static void main(String[] args)
            throws JDOMException, IOException {

        SAXBuilder sax = new SAXBuilder();

        Document document =
                sax.build(new File("TP1/newXMLDocument.xml"));

        Element racine = document.getRootElement();

        List<Element> staffList =
                racine.getChildren("staff");

        for (Element staff : staffList) {
            System.out.println("First name: "
                    + staff.getChildText("firstname"));

            System.out.println("Last name: "
                    + staff.getChildText("lastname"));

            System.out.println("Address: "
                    + staff.getChildText("Address"));

            System.out.println("Salary: "
                    + staff.getChildText("salary"));

            System.out.println("--------------------");
        }
    }
}
