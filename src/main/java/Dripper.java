import Objects.Arguments;
import Objects.Transaction;
import Utilities.DataProcessor;
import org.jsoup.nodes.Element;

import java.text.ParseException;
import java.util.ArrayList;

import static Utilities.FileHandler.getHtmlTableFromFile;

public class Dripper {

    public static void main(String[] args) throws ParseException {

        Arguments arguments;

        if (args.length > 0) {
            arguments = new Arguments(true);
        } else {
            arguments = new Arguments(false);
        }

        Element table = getHtmlTableFromFile(arguments.getInputFilePath());
        ArrayList<Transaction> transactions = DataProcessor.getTransactionsFromHTML(table);
        Boolean test = true;
    }
}
