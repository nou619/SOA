import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.FileWriter;
import org.json.JSONObject;
import org.json.XML;

public class Exercice4 {
    public static void main(String[] args) {
        try {
            // 1. Read the XML file
            String xml = new String(
                Files.readAllBytes(Paths.get("TP2/etudiant.xml")),
                java.nio.charset.StandardCharsets.UTF_8
            );

            // 2. Convert XML to JSON
            JSONObject json = XML.toJSONObject(xml);

            // 3. Display and save the JSON
            String resultat = json.toString(4);

            try (FileWriter file =
                     new FileWriter("TP2/etudiant.json")) {
                file.write(resultat);
            }

            System.out.println("Conversion terminée !");
            System.out.println(resultat);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
