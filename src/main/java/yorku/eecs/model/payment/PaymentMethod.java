package yorku.eecs.model.payment;

import javax.swing.*;

public interface PaymentMethod {

    public void pay(int total);
    public void requestPaymentDetails();

    public boolean verifyPaymentDetails();

}
