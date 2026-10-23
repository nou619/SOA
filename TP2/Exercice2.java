
import java.io.*;
import org.jdom.*;
import org.jdom.input.*;
import java.util.List;
import java.util.Iterator;

public class Exercice2 {
    static org.jdom.Document document;
    static Element racine;

    public static void main(String[] args) {
        SAXBuilder sxb = new SAXBuilder();

        try {
            document = sxb.build(new File("TP2/Exercice2.xml"));
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        racine = document.getRootElement();
        afficheNom();
        afficheClasse();
    }

    static void afficheNom() {
        List listEtudiants = racine.getChildren("etudiant");
        Iterator i = listEtudiants.iterator();

        while (i.hasNext()) {
            Element courant = (Element) i.next();
            System.out.println(courant.getChild("nom").getText());
        }
    }

    static void afficheClasse() {
        List listEtudiants = racine.getChildren("etudiant");
        Iterator i = listEtudiants.iterator();

        while (i.hasNext()) {
            Element courant = (Element) i.next();

            if (courant.getChild("nom").getText().equals("Ben Said")) {
                System.out.println("La classe de Ben Said est: "
                    + courant.getAttributeValue("classe"));
            }
        }
    }
}
