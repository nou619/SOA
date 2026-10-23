
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class Exercice2 {

    public static void main(String[] args)
            throws JDOMException, IOException {

        SAXBuilder builder = new SAXBuilder();

        File xmlFile = new File("TP1/Exercice2.xml");
        Document document = builder.build(xmlFile);

        Element rootNode = document.getRootElement();

        List<Element> list = rootNode.getChildren("tranche");

        for (Element node : list) {
            int age = Integer.parseInt(
                    node.getAttributeValue("age"));

            if (age >= 6 && age <= 10) {
                System.out.println("Age: " + age);
                System.out.println("nbFemmes: "
                        + node.getAttributeValue("nbFemmes"));
                System.out.println("nbHommes: "
                        + node.getAttributeValue("nbHommes"));
                System.out.println("--------------------");
            }
        }
    }
}
