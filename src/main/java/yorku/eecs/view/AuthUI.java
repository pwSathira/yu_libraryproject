package yorku.eecs.view;

import yorku.eecs.controller.card.ViewSwitcher;

import javax.swing.*;

public class AuthUI extends AuthBaseUI{

    public AuthUI(ViewSwitcher viewSwitcher) {
        super(viewSwitcher);
        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Register");
        leftPanel.add(loginButton, "span, align center, wrap");
        leftPanel.add(registerButton, "span, align center, wrap");
    }

    @Override
    protected void checkLogin() {}
}
