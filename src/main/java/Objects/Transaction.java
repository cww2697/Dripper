package Objects;

import java.util.Date;

public class Transaction {

    private long transactionID;
    private Date date;
    private String items;
    private String type;
    private Double price;
    private Boolean isRefundTransaction;
    private Boolean isWalletPurchase;
    private Boolean isMarketTransaction;
    private Boolean isInGamePurchase;

    public Transaction(
            long transactionID,
            Date date, String items,
            String type, Double price
    ) {
        this.transactionID = transactionID;
        this.date = date;
        this.items = items;
        this.type = type;
        this.price = price;
    }

    public long getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(long transactionID) {
        this.transactionID = transactionID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getRefundTransaction() {
        return isRefundTransaction;
    }

    public void setRefundTransaction(Boolean refundTransaction) {
        isRefundTransaction = refundTransaction;
    }

    public Boolean getWalletPurchase() {
        return isWalletPurchase;
    }

    public void setWalletPurchase(Boolean walletPurchase) {
        isWalletPurchase = walletPurchase;
    }

    public Boolean getMarketTransaction() {
        return isMarketTransaction;
    }

    public void setMarketTransaction(Boolean marketTransaction) {
        isMarketTransaction = marketTransaction;
    }

    public Boolean getInGamePurchase() {
        return isInGamePurchase;
    }

    public void setInGamePurchase(Boolean inGamePurchase) {
        isInGamePurchase = inGamePurchase;
    }
}
