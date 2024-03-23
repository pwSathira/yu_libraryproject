package yorku.eecs.model.payment;

import javax.swing.*;

public class PaymentByMobileWallet implements PaymentMethod {

    private JPanel contentPanel;


    public PaymentByMobileWallet(JPanel contentPanel) {
        this.contentPanel = contentPanel;
    }
    public void pay(int total) {
    };

    public void requestPaymentDetails() {
    }

    @Override
    public boolean verifyPaymentDetails() {
        return true;
    }


}
