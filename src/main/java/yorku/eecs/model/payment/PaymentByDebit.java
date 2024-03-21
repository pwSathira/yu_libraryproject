package yorku.eecs.model.payment;

import javax.swing.*;

public class PaymentByDebit implements PaymentMethod {

    private JPanel contentPanel;

    public PaymentByDebit(JPanel contentPanel) {
        this.contentPanel = contentPanel;
    }

    private Debit debitCard;

    public void pay(int total) {}

    @Override
    public void requestPaymentDetails() {

    }

    @Override
    public boolean verifyPaymentDetails() {
        return true;
    }

}
