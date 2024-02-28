package yorku.eecs.view;

import yorku.eecs.controller.ViewSwitcher;

import javax.swing.*;

public class LoginUI extends AuthBaseUI {
    private final ViewSwitcher viewSwitcher;

    public LoginUI(ViewSwitcher viewSwitcher) {
        super(viewSwitcher);
        this.viewSwitcher = viewSwitcher;
        setupFieldForEnterKey(passwordField);
        setupFieldForEnterKey(usernameField);
    }

    private void setupFieldForEnterKey(JComponent field) {
        if (field instanceof JPasswordField) {
            field.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
                        checkLogin();
                    }
                }
            });
        } else {
            field.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
                        passwordField.requestFocus();
                    }
                }
            });
        }
    }

}