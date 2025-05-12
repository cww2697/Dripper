package Utilities;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.IOException;

public class FileHandler {

    protected static String tableClassName = "wallet_history_table";

    public static Element getHtmlTableFromFile(String filePath) {
        try {
            File file = new File(filePath);
            Document doc = Jsoup.parse(file, "UTF-8");
            Element table = doc.select("table").first();

            if (table == null) {
                throw new IOException(
                        "No Table Found"
                );
            }

            if (!table.className().equals(tableClassName)) {
                throw new IOException(
                        "Invalid table class in HTML file."
                );
            }

            return table;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
