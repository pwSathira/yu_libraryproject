package yorku.eecs.view;

import javafx.scene.control.PasswordField;
import yorku.eecs.controller.ViewSwitcher;

import javax.swing.*;

public class RegisterUI extends AuthBaseUI{

    public RegisterUI(ViewSwitcher viewSwitcher) {
        super(viewSwitcher);
        JPasswordField confirmPasswordField = new JPasswordField(20);
        leftPanel.add(confirmPasswordField);
    }
}
