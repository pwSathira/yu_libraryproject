package yorku.eecs.model;

import java.util.Date;

public interface PaymentOptions {

    //interface for both the credit and debit classes since they share the same properties


    //getters
    public String getCardNumber();

    public String getCardHolderName();

    public String getCvv();

    public Date getExpiryDate();


    //setters
    public void setCardNumber(String cardNumber);

    public void setCardHolderName (String cardHolderName);

    public void setCvv(String cvv);

    public void setExpiryDate (Date expiryDate);




}
