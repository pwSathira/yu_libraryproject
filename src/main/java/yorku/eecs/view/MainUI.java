package yorku.eecs.view;

import yorku.eecs.controller.card.ViewSwitcher;
import yorku.eecs.controller.card.CardController;
import yorku.eecs.model.user.User;

import javax.swing.*;
import java.awt.*;

public class MainUI extends JFrame implements ViewSwitcher {
    private final CardController cardController;
    private final ViewSwitcher viewSwitcher = this;
    private final JPanel cardPanel;

    public MainUI() {
        // Setup JFrame
        setTitle("YorkU Library System");
        setSize(1080, 720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon("src/main/resources/static/favicon.png").getImage());

        // Set cardPanel to use CardLayout
        this.cardPanel = new JPanel(new CardLayout());
        this.cardController = new CardController(cardPanel);

        // Initialize UIs
        initializeUI();

        // Add cardPanel and buttonPanel to the frame
        add(cardPanel, BorderLayout.CENTER);
        setVisible(true);
    }
    private void initializeUI() {
        BootUI bootUI = new BootUI(this);
        cardPanel.add(bootUI, "Boot");
        LoginUI loginUI = new LoginUI(this);
        cardPanel.add(loginUI, "Login");
        RegisterUI registerUI = new RegisterUI(this);
        cardPanel.add(registerUI, "Register");
        BookUI bookUI = new BookUI(this);
        cardPanel.add(bookUI, "Book");
        AuthUI authUI = new AuthUI(this);
        cardPanel.add(authUI, "Auth");
    }
    private void loginDependantUIs() {
        HomeUI homeUI = new HomeUI(this);
        cardPanel.add(homeUI, "Home");
        AdminHomeUI adminHomeUI = new AdminHomeUI(this);
        cardPanel.add(adminHomeUI, "AdminHome");
    }
    @Override
    public void switchView(String viewName) {
        cardController.showCard(viewName);
    }
    @Override
    public void setUser(User user) {
        cardController.setUser(user);
        loginDependantUIs();
    }

    @Override
    public User getUser() {
        return cardController.getUser();
    }


}
