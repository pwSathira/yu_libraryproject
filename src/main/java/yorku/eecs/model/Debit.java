package yorku.eecs.model;

import java.util.Date;

public class Debit implements PaymentOptions{

    private String cardNumber;
    private String cardHolderName;
    private String cvv;
    private Date expiryDate;

    public Debit(){
    }
    public Debit(String cardNumber, String cardHolderName, String cvv, Date expiryDate){
        this.cardHolderName = cardHolderName;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
    }

    public String getCardHolderName() {
        return this.cardHolderName;
    }

    public String getCardNumber(){

        return this.cardNumber;
    }

    public String getCvv() {
        return this.cvv;
    }

    public Date getExpiryDate(){
        return this.expiryDate;
    }


    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }


    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;

    }


    public void setCvv(String cvv) {
        this.cvv = cvv;

    }


    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;

    }


}
