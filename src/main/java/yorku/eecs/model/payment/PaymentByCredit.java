package yorku.eecs.model.payment;

import yorku.eecs.controller.card.ViewSwitcher;
import yorku.eecs.view.HomeBaseUI;

import javax.swing.*;
import java.awt.*;

public class PaymentByCredit implements PaymentMethod {
    private JTextField cardNumber;

    private JTextField cardName;
    private JTextField expiryDate;
    private JTextField cvv;
    private JPanel contentPanel;


    public PaymentByCredit(JPanel contentPanel) {
        this.contentPanel = contentPanel;
    }
    private Credit creditCard;

    public void pay(int total) {
    }

    public void requestPaymentDetails() {

        cardNumber = new JTextField(16);
        JLabel cardNumberLabel = new JLabel("16 digit card number");
        cardNumberLabel.setFont(new Font("Arial", Font.BOLD, 12));

        cardName = new JTextField(20);
        JLabel cardNameLabel = new JLabel("card holder's name");
        cardNameLabel.setFont(new Font("Arial", Font.BOLD, 12));

        expiryDate = new JTextField(8);
        JLabel expiryDateLabel = new JLabel("expiry date");
        expiryDateLabel.setFont(new Font("Arial", Font.BOLD, 12));

        cvv = new JTextField(3);
        JLabel cvvLabel = new JLabel("cvv");
        cvvLabel.setFont(new Font("Arial", Font.BOLD, 12));

        contentPanel.add(cardNameLabel);
        contentPanel.add(cardName, "wrap");
        contentPanel.add(cardNumberLabel);
        contentPanel.add(cardNumber, "wrap");
        contentPanel.add(expiryDateLabel);
        contentPanel.add(expiryDate, "wrap");
        contentPanel.add(cvvLabel);
        contentPanel.add(cvv, "wrap");
    }

    @Override
    public boolean verifyPaymentDetails() {
        return checkCardNumber() && checkExpiryDate() && checkCvv();
    }

    private boolean checkCardNumber() {
        String cardNumText = cardNumber.getText();

        try {
            if ((cardNumText.length() == 16)) {
                Integer.parseInt(cardNumText);
                return true;
            }
            else {
                return false;
            }
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    private boolean checkExpiryDate() {

        String expiryText = expiryDate.getText();

        try {
            if ((expiryText.length() == 8)) {
                Integer.parseInt(expiryText);
                return true;
            }
            else {
                return false;
            }
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    private boolean checkCvv() {
        String cvvText = cvv.getText();

        try {
            if ((cvvText.length() == 3)) {
                Integer.parseInt(cvvText);
                return true;
            }
            else {
                return false;
            }
        } catch (NumberFormatException ex) {
            return false;
        }
    }


}
