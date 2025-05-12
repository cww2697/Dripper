import Objects.Transaction;
import Utilities.DataProcessor;
import org.jsoup.nodes.Element;

import java.text.ParseException;
import java.util.ArrayList;

import static Utilities.FileHandler.getHtmlTableFromFile;

public class Dripper {

    public static void main(String[] args) throws ParseException {

        if (args.length > 0) {

        }
        String filePath = "";

        Element table = getHtmlTableFromFile(filePath);
        ArrayList<Transaction> transactions = DataProcessor.getTransactionsFromHTML(table);
        Boolean test = true;
    }
}
