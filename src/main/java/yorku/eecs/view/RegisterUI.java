package yorku.eecs.view;

import yorku.eecs.controller.ControllerError;
import yorku.eecs.controller.card.ViewSwitcher;
import yorku.eecs.controller.user.UserController;
import yorku.eecs.logic.PasswordChecker;
import yorku.eecs.model.user.User;
import yorku.eecs.logic.IdField;
import yorku.eecs.model.user.UserFactory;
import yorku.eecs.model.user.Visitor;

import javax.swing.*;
import java.awt.event.ActionListener;

public class RegisterUI extends AuthBaseUI {
    private IdField yorkIDField;
    private JTextField usernameField;
    private JTextField emailField;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JPasswordField passwordField;
    private JComboBox<String> roleComboBox;

    public RegisterUI(ViewSwitcher viewSwitcher) {
        super(viewSwitcher);
        addFields();
    }

    private void addFields() {
        yorkIDField = new IdField();
        yorkIDField.setColumns(20);
        JLabel yorkIDLabel = new JLabel("YorkID");

        usernameField = new JTextField();
        usernameField.setColumns(20);
        JLabel usernameLabel = new JLabel("Username");

        emailField = new JTextField();
        emailField.setColumns(20);
        JLabel emailLabel = new JLabel("Email");

        firstNameField = new JTextField();
        firstNameField.setColumns(20);
        JLabel firstNameLabel = new JLabel("First Name");

        lastNameField = new JTextField();
        lastNameField.setColumns(20);
        JLabel lastNameLabel = new JLabel("Last Name");

        passwordField = new JPasswordField(20);
        JLabel passwordLabel = new JLabel("Password");

        roleComboBox = new JComboBox<>();
        roleComboBox.addItem("Student");
        roleComboBox.addItem("Faculty");
        roleComboBox.addItem("Non-Faculty");
        roleComboBox.addItem("Visitor");
        JLabel roleLabel = new JLabel("Roles");

        leftPanel.add(yorkIDLabel);
        leftPanel.add(yorkIDField, "align center, wrap");
        leftPanel.add(usernameLabel);
        leftPanel.add(usernameField, "align center, wrap");
        leftPanel.add(emailLabel);
        leftPanel.add(emailField, "align center, wrap");
        leftPanel.add(firstNameLabel);
        leftPanel.add(firstNameField, "align center, wrap");
        leftPanel.add(lastNameLabel);
        leftPanel.add(lastNameField, "align center, wrap");
        leftPanel.add(passwordLabel);
        leftPanel.add(passwordField, "align center, wrap");
        leftPanel.add(roleLabel);
        leftPanel.add(roleComboBox, "align center, wrap");

        ActionListener actionListener = e -> onButtonClicked(e.getActionCommand());
        addFooterLabel(this.leftPanel, actionListener, "Register");
    }

    @Override
    protected JButton addFooterLabel(JPanel panel, ActionListener actionListener, String actionCommand) {
        JButton registerButton = super.addFooterLabel(panel, actionListener, actionCommand);
        registerButton.setActionCommand(actionCommand);
        return registerButton;
    }

    @Override
    protected void onButtonClicked(String actionCommand) {
        if ("Register".equals(actionCommand)) {
            String yorkID = yorkIDField.getText();
            String username = usernameField.getText();
            String email = emailField.getText();
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String password = new String(passwordField.getPassword());
            String role = roleComboBox.getSelectedItem().toString();

            if (!PasswordChecker.checkStrength(password)){
                JOptionPane.showMessageDialog(null, "Password must be at least 8 characters long and contain at least one uppercase letter, one lowercase letter, one digit, and one special character.");
                return;
            }

            UserController userController = new UserController();
            String userType = userController.determineUserType(yorkID);
            User user = UserFactory.createUser(userType, yorkID, password);
            user.setEmailAddress(email);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setUserName(username);

            try {
                boolean userExists = userController.checkUserExists(user);
                if (!userExists && "Visitor".equals(role) && user instanceof Visitor) {
                    userController.createUser(user);
                    JOptionPane.showMessageDialog(null, "Registration successful!");
                    viewSwitcher.switchView("Home");
                } else if (!userExists && !"Visitor".equals(role)) {
                    //Use user controller to add to admin queue
                    userController.addToAdminQueue(user);
                    JOptionPane.showMessageDialog(null, "Registration successful! Please wait for an admin to approve your account.");
                    viewSwitcher.switchView("Login");
                } else {
                    JOptionPane.showMessageDialog(null, "User already exists or invalid role selected.");
                }
            } catch (ControllerError e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
