package yorku.eecs.view;

import yorku.eecs.controller.card.ViewSwitcher;
import yorku.eecs.controller.user.UserController;
import yorku.eecs.model.user.User;

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
//        User
        UserController userController = new UserController();
//        userController.createUser()

    }

    @Override
    protected void checkLogin() {
    }
}
