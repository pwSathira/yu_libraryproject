package yorku.eecs.view;

import yorku.eecs.controller.card.ViewSwitcher;
import yorku.eecs.logic.ImageProcessor;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AuthUI extends AuthBaseUI {

    private JButton loginButton;
    private JButton registerButton;

    public AuthUI(ViewSwitcher viewSwitcher) {
        super(viewSwitcher);
        initButtons();
    }

    @Override
    protected void onButtonClicked(String actionCommand) {
        // Logic for handling button clicks
        if ("Register".equals(actionCommand)) {
            System.out.println("Navigate to Register UI");
            viewSwitcher.switchView("Register");
        } else {
            System.out.println("Navigate to Login UI");
            viewSwitcher.switchView("Login");
        }
    }

    private void initButtons() {
        // Initialize buttons
        loginButton = new JButton();
        registerButton = new JButton();

        // Assuming the ImageProcessor class has methods for resizing and darkening icons
        ImageIcon registerIcon = new ImageIcon("src/main/resources/static/authbaseui/Register.png");
        ImageIcon loginIcon = new ImageIcon("src/main/resources/static/authbaseui/Login.png");
        loginIcon = ImageProcessor.resizeIcon(loginIcon, 200, 50);
        registerIcon = ImageProcessor.resizeIcon(registerIcon, 200, 50);

        // Set icons
        loginButton.setIcon(loginIcon);
        registerButton.setIcon(registerIcon);

        // Apply icons and hover effects
        buttonIconFunctions(loginIcon, loginButton);
        buttonIconFunctions(registerIcon, registerButton);

        // Set action commands
        loginButton.setActionCommand("Login");
        registerButton.setActionCommand("Register");

        // Add action listeners
        loginButton.addActionListener(e -> onButtonClicked(e.getActionCommand()));
        registerButton.addActionListener(e -> onButtonClicked(e.getActionCommand()));

        // Add buttons to the panel
        leftPanel.add(loginButton, "span, align center, wrap");
        leftPanel.add(registerButton, "span, align center, wrap");
    }
}
