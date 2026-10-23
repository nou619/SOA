
import java.io.*;
import org.jdom.*;
import org.jdom.output.*;

public class Exercice1 {

    // Création de la racine du document XML
    static Element racine = new Element("personnes");

    // Création du document basé sur la racine
    static Document document = new Document(racine);

    public static void main(String[] args) {

        // Création de l'élément etudiant
        Element etudiant = new Element("etudiant");
        racine.addContent(etudiant);

        // Ajout de l'attribut classe
        Attribute classe = new Attribute("classe", "IG3");
        etudiant.setAttribute(classe);

        // Création de l'élément nom
        Element nom = new Element("nom");
        nom.setText("Ben Saied");
        etudiant.addContent(nom);

        // Création de l'élément prenom
        Element prenom = new Element("prenom");
        prenom.setText("Ahmed");
        etudiant.addContent(prenom);

        // Création de l'élément CIN
        Element cin = new Element("CIN");
        cin.setAttribute("num", "08656733");
        cin.setAttribute("date", "08 Juillet 2000");
        etudiant.addContent(cin);

        // Affichage du document XML
        affiche();

        // Enregistrement du document dans un fichier XML
        enregistrer("Exercice1.xml");
    }

    static void affiche() {
        try {
            // Affichage formaté du document XML
            XMLOutputter sortie =
                new XMLOutputter(Format.getPrettyFormat());

            sortie.output(document, System.out);
        }
        catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    static void enregistrer(String fichier) {
        try {
            // Enregistrement du document XML dans un fichier
            XMLOutputter sortie =
                new XMLOutputter(Format.getPrettyFormat());

            sortie.output(document, new FileOutputStream(fichier));
        }
        catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
