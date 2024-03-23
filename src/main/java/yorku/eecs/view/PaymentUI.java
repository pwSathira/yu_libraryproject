//package yorku.eecs.view;
//
//import yorku.eecs.controller.card.ViewSwitcher;
//import yorku.eecs.model.payment.PaymentByCredit;
//import yorku.eecs.model.payment.PaymentByDebit;
//import yorku.eecs.model.payment.PaymentByMobileWallet;
//import yorku.eecs.model.payment.PaymentMethod;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class PaymentUI extends HomeBaseUI {
//
//    private PaymentMethod payMethod;
//
//    protected JComboBox paymentMenu;
//
//    protected JButton pay;
//
//    private int total;
//
//    private String[] paymentOptions = {"credit", "debit", "mobile wallet"};
//
//    public PaymentUI(ViewSwitcher viewSwitcher) {
//        super(viewSwitcher);
//        init();
//
//    }
//    private void init() {
//        paymentMenu = new JComboBox(paymentOptions);
//        paymentMenu.addActionListener(e -> actionPerformed(paymentMenu.getSelectedItem().toString()));
//
//        pay = new JButton("Pay");
//        pay.setActionCommand("pay");
//        pay.addActionListener(e -> actionPerformed(e.getActionCommand()));
//
//        contentPanel.add(paymentMenu);
//        contentPanel.add(pay);
//    }
//
//    private void actionPerformed(String pressed) {
//
//        JLabel test = new JLabel("Test");
//        test.setFont(new Font("Arial", Font.BOLD, 12));
//        contentPanel.add(test);
//
//        if (pressed.equals("credit")) {
//            //contentPanel.removeAll();
//            //init();
//
//            payMethod = new PaymentByCredit(contentPanel);
//            payMethod.requestPaymentDetails();
//            }
//        else if (pressed.equals("debit")) {
//            contentPanel.removeAll();
//            init();
//            payMethod = new PaymentByDebit(contentPanel);
//            payMethod.requestPaymentDetails();
//        }
//        else if (pressed.equals("mobile wallet")) {
//            contentPanel.removeAll();
//            init();
//            payMethod = new PaymentByMobileWallet(contentPanel);
//            payMethod.requestPaymentDetails();
//        }
//        else if (pressed.equals("pay")) {
//            if (payMethod.verifyPaymentDetails()) {
//
//                contentPanel.removeAll();
//                JLabel successLabel = new JLabel("You have successfully");
//                successLabel.setFont(new Font("Arial", Font.BOLD, 30));
//                contentPanel.add(successLabel);
//            }
//
//        }
//    }
//
//    private void comboBoxListener() {
//        ActionListener comboListener = new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // Get the selected item from the JComboBox
//                String selectedOption = (String) paymentMenu.getSelectedItem();
//                // Do something with the selected item
//
//            }
//        };
//    }
//}
