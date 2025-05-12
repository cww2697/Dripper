package Utilities;

import Objects.Transaction;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataProcessor {

    public static ArrayList<Transaction> getTransactionsFromHTML(Element table) throws ParseException {
        ArrayList<Transaction> transactions = new ArrayList<>();

        for (Element tr : table.select("tr")) {
            Elements cells = tr.select("td");
            List<String> cellValues = new ArrayList<>();

            for (Element cell : cells) {

                if (cell.hasClass("wht_items") || cell.hasClass("wht_type")){
                    String cellText = cleanCellValue(cell, false);
                    if (cellText.isEmpty()) {
                        continue;
                    }
                    cellValues.add(cellText);
                } else if (cell.hasClass("wht_total")){
                    String cellText = cleanCellValue(cell, true);
                    if (cellText.isEmpty()) {
                        continue;
                    }
                    cellValues.add(cellText);
                } else if (cell.hasClass("wht_wallet_change") || cell.hasClass("wht_wallet_balance")) {
                    continue;
                } else {
                    cellValues.add(cell.text().trim());
                }
            }

            if (cellValues.isEmpty()) {
                continue;
            }

            String TransactionIdAttr = tr.attr("onclick");
            long transactionId = getTransactionId(TransactionIdAttr);

            Transaction transObject = createTransactionObject(cellValues, transactionId);
            transactions.add(transObject);

        }

        return transactions;
    }

    private static long getTransactionId(String attr)
    {
        long transactionId = 0;

        Pattern pattern = Pattern.compile("transid=(\\d+)");
        Matcher matcher = pattern.matcher(attr);

        if (matcher.find()) {
            transactionId = Long.parseLong(matcher.group(1));
        }

        return transactionId;
    }

    private static Boolean getTransactionType(String cellValue)
    {
        return cellValue.toLowerCase().contains("refund");
    }

    private static String cleanCellValue(Element cell, boolean isTotal)
    {
        Element itemName;
        boolean useTdTagValue = false;

        itemName = cell.getElementsByTag("div").first();

        if (itemName == null) {
            useTdTagValue = true;
        }

        String itemValue = "";

        if (useTdTagValue) {
            itemName = cell.getElementsByTag("td").first();
            assert itemName != null;
        }

        itemValue = itemName.text().trim();

        if (isTotal) {
            itemValue = itemValue.substring(1);
        }

        return itemValue;
    }

    private static Transaction createTransactionObject(List<String> cellValues, long transactionId) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy");
        Date date = sdf.parse(cellValues.get(0));
        String itemName = cellValues.get(1);
        String type = cellValues.get(2);
        double itemValue = Double.parseDouble(cellValues.get(3));
        Boolean isRefund = type.toLowerCase().contains("refund");

        if (isRefund) {
            itemValue = itemValue * -1;
        }

        Transaction transObject = new Transaction(
                transactionId,
                date,
                itemName,
                type,
                itemValue
        );

        transObject.setRefundTransaction(isRefund);
        transObject.setInGamePurchase(type.toLowerCase().contains("in-game purchase"));
        transObject.setMarketTransaction(type.toLowerCase().contains("market transaction"));
        transObject.setWalletPurchase(itemName.toLowerCase().contains("wallet credit"));

        return transObject;
    }
}
