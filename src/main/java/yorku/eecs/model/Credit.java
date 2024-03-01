package yorku.eecs.model;

import java.util.Date;

public class Credit implements PaymentOptions{
    private String cardNumber;
    private String cardHolderName;
    private String cvv;
    private Date expiryDate;

    public Credit(){
    }
    public Credit(String cardNumber, String cardHolderName, String cvv, Date expiryDate){
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
    }

    //getters
    public String getCardNumber() { return this.cardNumber; }
    public String getCardHolderName() { return this.cardHolderName; }
    public String getCvv() { return this.cvv; }
    public Date getExpiryDate() {return this.expiryDate; }

    // setters
    public void setCardNumber(String cardNumber){
        this.cardNumber = cardNumber;
    }
    public void setCardHolderName(String cardHolderName){
        this.cardHolderName = cardHolderName;
    }
    public void setCvv(String cvv){
        this.cvv = cvv;
    }
    public void setExpiryDate(Date expiryDate){
        this.expiryDate = expiryDate;
    }
}