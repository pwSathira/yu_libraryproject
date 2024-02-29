package yorku.eecs.view;

import yorku.eecs.controller.ViewSwitcher;

import javax.swing.*;

public class RegisterUI extends AuthBaseUI {
    private JPasswordField confirmPasswordField;

    public RegisterUI(ViewSwitcher viewSwitcher) {
        super(viewSwitcher);
        JLabel confirmPasswordLabel = new JLabel("Confirm Password");
        confirmPasswordField = new JPasswordField(20);
        leftPanel.add(confirmPasswordLabel);
        leftPanel.add(confirmPasswordField, "wrap");
        addFooterLabel(this.leftPanel);
    }

    @Override
    protected void checkLogin() {
    }
}
