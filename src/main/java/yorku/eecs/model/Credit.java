package yorku.eecs.model;

import java.util.Date;

public class Credit extends Payment{
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

    // setters
    public void setCardNumber(String cardNumber){
        this.cardNumber = cardNumber;
    }
    public void setCardHolderName(String cardHolderName){
        this.cardHolderName = cardHolderName;
    }
    public void setCvv(String cvv){

    }
}