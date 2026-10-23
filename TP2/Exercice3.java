
import java.io.File;
import java.io.FileOutputStream;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.jdom.input.SAXBuilder;
import java.util.List;
import java.util.Iterator;

public class Exercice3 {
    public static void main(String[] args) {
        try {
            // 1. Create the XML structure
            Element diplomes = new Element("diplomes");
            Element licence = new Element("licence");
            Element semestre = new Element("semestre");

            Element parcoursInfo = new Element("parcours");
            parcoursInfo.setAttribute("id", "Info");
            parcoursInfo.addContent(new Element("nom").setText("Algorithmiques"));
            parcoursInfo.addContent(new Element("nom").setText("JavaScript"));
            semestre.addContent(parcoursInfo);

            String[][] parcoursData = {
                {"ModSim", "Modélisation et simulation"},
                {"Eco", "Economie"},
                {"Ma", "Mathematiques"},
                {"Ts", "Techniques Statistiques"},
                {"Pluri", "Pluridisciplinaire"}
            };

            for (String[] data : parcoursData) {
                Element parcours = new Element("parcours");
                parcours.setAttribute("id", data[0]);
                parcours.addContent(new Element("nom").setText(data[1]));
                semestre.addContent(parcours);
            }

            licence.addContent(semestre);
            diplomes.addContent(licence);

            Document document = new Document(diplomes);

            // 2. Save the XML file
            XMLOutputter sortie = new XMLOutputter(
                Format.getPrettyFormat().setEncoding("ISO-8859-1")
            );
            sortie.output(document, new FileOutputStream("TP2/Exercice3.xml"));

            System.out.println("Fichier Exercice3.xml créé !");

            // 3. Read the XML file and display names for id="Info"
            SAXBuilder sxb = new SAXBuilder();
            Document doc = sxb.build(new File("TP2/Exercice3.xml"));
            Element racine = doc.getRootElement();

            List parcoursList = racine
                .getChild("licence")
                .getChild("semestre")
                .getChildren("parcours");

            Iterator i = parcoursList.iterator();

            while (i.hasNext()) {
                Element parcours = (Element) i.next();

                if (parcours.getAttributeValue("id").equals("Info")) {
                    List noms = parcours.getChildren("nom");
                    Iterator j = noms.iterator();

                    while (j.hasNext()) {
                        Element nom = (Element) j.next();
                        System.out.println(nom.getText());
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
