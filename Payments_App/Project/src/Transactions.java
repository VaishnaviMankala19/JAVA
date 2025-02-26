import java.util.Date;

public class Transactions {
    private int transactionId;
    private Date transactionDateTime;
    private int sourceId;
    private int targetId;
    private int sourceTypeId;
    private int destinationTypeId;
    private double amount;
    public int getTransactionId() {
        return transactionId;
    }
    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }
    public Date getTransactionDateTime() {
        return transactionDateTime;
    }
    public void setTransactionDateTime(Date transactionDateTime) {
        this.transactionDateTime = transactionDateTime;
    }
    public int getSourceId() {
        return sourceId;
    }
    public void setSourceId(int sourceId) {
        this.sourceId = sourceId;
    }
    public int getTargetId() {
        return targetId;
    }
    public void setTargetId(int targetId) {
        this.targetId = targetId;
    }
    public int getSourceTypeId() {
        return sourceTypeId;
    }
    public void setSourceTypeId(int sourceTypeId) {
        this.sourceTypeId = sourceTypeId;
    }
    public int getDestinationTypeId() {
        return destinationTypeId;
    }
    public void setDestinationTypeId(int destinationTypeId) {
        this.destinationTypeId = destinationTypeId;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    
}
