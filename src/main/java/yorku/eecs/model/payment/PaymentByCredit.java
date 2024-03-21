package yorku.eecs.model.payment;

import yorku.eecs.controller.card.ViewSwitcher;
import yorku.eecs.view.HomeBaseUI;

import javax.swing.*;
import java.awt.*;

public class PaymentByCredit extends HomeBaseUI implements PaymentMethod {


    private Credit credit = new Credit();
    private JTextField cardNumber;

    private JTextField cardName;
    private JTextField expiryDate;
    private JTextField cvv;


    public PaymentByCredit() {
        super();
    }
    private Credit creditCard;

    public void pay(int total) {

       // creditCard = new Credit()

    }

    public void getPaymentDetails(J) {

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

    }




}
