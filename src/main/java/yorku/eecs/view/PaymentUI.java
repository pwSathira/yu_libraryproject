package yorku.eecs.view;

import yorku.eecs.controller.card.ViewSwitcher;
import yorku.eecs.model.payment.PaymentByCredit;
import yorku.eecs.model.payment.PaymentByDebit;
import yorku.eecs.model.payment.PaymentByMobileWallet;
import yorku.eecs.model.payment.PaymentMethod;

import javax.swing.*;

public class PaymentUI extends HomeBaseUI {

    private PaymentMethod payMethod;

    protected JComboBox paymentMenu;

    protected JButton pay;

    private String[] paymentOptions = {"credit", "debit", "mobile wallet"};

    public PaymentUI(ViewSwitcher viewSwitcher) {
        super(viewSwitcher);

    }
    private void init() {
        paymentMenu = new JComboBox(paymentOptions);
        paymentMenu.setActionCommand("Menu");
        paymentMenu.addActionListener(e -> actionPerformed(e.getActionCommand()));
    }

    private void actionPerformed(String pressed) {
        if (pressed.equals("Menu")) {
            if (paymentMenu.getSelectedItem().equals("credit")) {
                payMethod = new PaymentByCredit();
            }
            else if (paymentMenu.getSelectedItem().equals("debit")) {
                payMethod = new PaymentByDebit();
            }
            else if (paymentMenu.getSelectedItem().equals("mobile wallet")) {
                payMethod = new PaymentByMobileWallet();
            }

            payMethod.getPaymentDetails();
        }
    }
}
