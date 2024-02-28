package yorku.eecs.view;

import net.miginfocom.swing.MigLayout;
import yorku.eecs.controller.UserController;
import yorku.eecs.controller.ViewSwitcher;
import yorku.eecs.logic.BackgroundPanel;
import yorku.eecs.logic.ImageProcessor;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public abstract class AuthBaseUI extends JPanel{
    private final ViewSwitcher viewSwitcher;
    protected final JTextField usernameField;
    protected final JPasswordField passwordField;

    protected JPanel leftPanel;
    protected BackgroundPanel rightPanel;

    public AuthBaseUI(ViewSwitcher viewSwitcher) {
        this.viewSwitcher = viewSwitcher;
        String logoPath = "src/main/resources/static/loginui/LoginUI_Logo.png";
        ImageIcon titleIcon = new ImageIcon(logoPath);
        titleIcon = ImageProcessor.resizeIcon(titleIcon, 300, 100);
        String arrowPath = "src/main/resources/static/loginui/LoginUI_Arrow.png";
        ImageIcon buttonIcon = new ImageIcon(arrowPath);
        buttonIcon = ImageProcessor.resizeIcon(buttonIcon, 50, 50);

        // Use MigLayout as the main layout manager with two columns
        setLayout(new MigLayout("insets 0, fill", "[30%]0[70%]", "[grow]"));

        // Initialize the left panel with MigLayout for the login form
        JPanel leftPanel = new JPanel(new MigLayout("wrap 2", "[][grow,fill]", "[]10[]10[]10[]"));
        leftPanel.setBackground(Color.WHITE);
        leftPanel.setBorder(new EmptyBorder(20,20,20,20));
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        JButton loginButton = new JButton(buttonIcon);
        JButton titleButton = new JButton(titleIcon);
        buttonIconFunctions(buttonIcon, loginButton);
        buttonIconFunctions(titleIcon, titleButton);

        JLabel footerLabel = new JLabel("version 0.1 Alpha");
        footerLabel.setFont(new Font("Arial", Font.ITALIC, 12));
        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 12));
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 12));

        // Add components to the left panel
        leftPanel.add(titleButton, "span, align center, wrap, gaptop 100");
        leftPanel.add(usernameLabel);
        leftPanel.add(usernameField, "align center, wrap");
        leftPanel.add(passwordLabel);
        leftPanel.add(passwordField, "align center, wrap");
        leftPanel.add(loginButton, "span, align center");
        leftPanel.add(footerLabel, "span, align center, wrap");
        this.leftPanel = leftPanel;

        // Initialize the right panel to display a background image that fills the space
        String bgPath = "src/main/resources/static/loginui/LoginUI_BG.png";
        BackgroundPanel rightPanel = new BackgroundPanel(bgPath);
        rightPanel.setBackground(new Color(0xE31837));
        this.rightPanel = rightPanel;

        // Add both panels to the main panel
        add(leftPanel, "grow");
        add(rightPanel, "grow");

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

    private void buttonIconFunctions(ImageIcon icon, JButton button) {
        button.setBorder(null);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusable(false);
        ImageIcon darkenedIcon = ImageProcessor.darkenImageIcon(icon, 0.5f);

        //Button Hover Effects
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setIcon(darkenedIcon);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                button.setIcon(icon);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                checkLogin();
            }
        });

    }

    protected void checkLogin() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        if (UserController.login(username, password)) {
            viewSwitcher.setUser(UserController.getUser(username));
            viewSwitcher.switchView("Book");
        } else {
            JOptionPane.showMessageDialog(null, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
