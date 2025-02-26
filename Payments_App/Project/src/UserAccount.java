import java.util.Date;

public class UserAccount {
    private int accountId;
    private int userId;
    private Date accountOpenDate;
    private String walletPin;
    private double currentWalletBalance;
    private int linkedBankAccountsCount;
    
    public int getAccountId() {
        return accountId;
    }
    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public Date getAccountOpenDate() {
        return accountOpenDate;
    }
    public void setAccountOpenDate(Date accountOpenDate) {
        this.accountOpenDate = accountOpenDate;
    }
    public String getWalletPin() {
        return walletPin;
    }
    public void setWalletPin(String walletPin) {
        this.walletPin = walletPin;
    }
    public double getCurrentWalletBalance() {
        return currentWalletBalance;
    }
    public void setCurrentWalletBalance(double currentWalletBalance) {
        this.currentWalletBalance = currentWalletBalance;
    }
    public int getLinkedBankAccountsCount() {
        return linkedBankAccountsCount;
    }
    public void setLinkedBankAccountsCount(int linkedBankAccountsCount) {
        this.linkedBankAccountsCount = linkedBankAccountsCount;
    }
    
}
