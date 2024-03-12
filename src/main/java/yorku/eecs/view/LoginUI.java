package yorku.eecs.view;

import yorku.eecs.controller.ControllerError;
import yorku.eecs.controller.card.ViewSwitcher;
import yorku.eecs.controller.user.AdminController;
import yorku.eecs.model.user.User;
import yorku.eecs.model.user.UserFactory;

import javax.swing.*;
import java.awt.event.ActionListener;

public class LoginUI extends AuthBaseUI {
    private JButton loginButton;
    private User user;
    public LoginUI(ViewSwitcher viewSwitcher) {
        super(viewSwitcher);
        addAuthLabel();

        ActionListener actionListener = e -> onButtonClicked(e.getActionCommand());
        this.loginButton = addFooterLabel(this.leftPanel, actionListener, "Login");

        //Enter key listener
        ActionListener enterPressedListener = e -> onButtonClicked("Login");
        idField.addActionListener(enterPressedListener);
        passwordField.addActionListener(enterPressedListener);
    }

    @Override
    protected JButton addFooterLabel(JPanel panel, ActionListener actionListener, String actionCommand) {
        JButton loginButton = super.addFooterLabel(panel, actionListener, actionCommand);
        loginButton.setActionCommand(actionCommand);
        return loginButton;
    }
    @Override
    protected void onButtonClicked(String actionCommand) {
        String id = idField.getText();
        String password = passwordField.getText();
        boolean isAuthenticated = validateCredentials(id, password);
        if (isAuthenticated) {
            viewSwitcher.setUser(user);
            viewSwitcher.switchView("Home");
        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean validateCredentials(String id, String password) {
        AdminController adminController = new AdminController();
        try {
            String userType = adminController.determineUserType(id);
            user = adminController.readUser(id, userType);
            User userInput = UserFactory.createUser(userType, id, password);
            return adminController.authenticateUser(user, userInput);
        } catch (ControllerError e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}