package yorku.eecs.model.payment;

public class MobileWallet {
    private String accountNumber;
    private String accountUsername;

    public MobileWallet(String accountNumber, String accountUsername){
        this.accountNumber = accountNumber;
        this.accountUsername = accountUsername;
    }

    public String getAccountNumber() { return this.accountNumber; }
    public String getAccountUsername() { return this.accountUsername; }
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }
    public void setAccountUsername(String accountUsername) { this.accountUsername = accountUsername; }
}
