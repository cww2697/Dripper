package Objects;

public class Arguments {

    private boolean useCmdArgs;
    private String inputFilePath;
    private boolean outputCSV;
    private String outputFilePath;
    private boolean excludeWalletPurchases;
    private boolean excludeRefundTransactions;
    private boolean excludeMarketTransactions;
    private boolean excludeInGamePurchases;

    public Arguments(boolean useCmdArgs) {
        this.useCmdArgs = useCmdArgs;
    }

    public boolean isUseCmdArgs() {
        return useCmdArgs;
    }

    public void setUseCmdArgs(boolean useCmdArgs) {
        this.useCmdArgs = useCmdArgs;
    }

    public String getInputFilePath() {
        return inputFilePath;
    }

    public void setInputFilePath(String inputFilePath) {
        this.inputFilePath = inputFilePath;
    }

    public boolean isExcludeWalletPurchases() {
        return excludeWalletPurchases;
    }

    public void setExcludeWalletPurchases(boolean excludeWalletPurchases) {
        this.excludeWalletPurchases = excludeWalletPurchases;
    }

    public boolean isExcludeRefundTransactions() {
        return excludeRefundTransactions;
    }

    public void setExcludeRefundTransactions(boolean excludeRefundTransactions) {
        this.excludeRefundTransactions = excludeRefundTransactions;
    }

    public boolean isExcludeMarketTransactions() {
        return excludeMarketTransactions;
    }

    public void setExcludeMarketTransactions(boolean excludeMarketTransactions) {
        this.excludeMarketTransactions = excludeMarketTransactions;
    }

    public boolean isExcludeInGamePurchases() {
        return excludeInGamePurchases;
    }

    public void setExcludeInGamePurchases(boolean excludeInGamePurchases) {
        this.excludeInGamePurchases = excludeInGamePurchases;
    }
}
