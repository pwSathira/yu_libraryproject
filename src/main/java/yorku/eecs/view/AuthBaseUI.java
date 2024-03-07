package yorku.eecs.view;

import net.miginfocom.swing.MigLayout;
import yorku.eecs.controller.card.ViewSwitcher;
import yorku.eecs.logic.BackgroundPanel;
import yorku.eecs.logic.ImageProcessor;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public abstract class AuthBaseUI extends JPanel {
    protected ViewSwitcher viewSwitcher;
    protected JTextField usernameField;
    protected JPasswordField passwordField;
    protected JPanel leftPanel;
    protected BackgroundPanel rightPanel;

    public AuthBaseUI(ViewSwitcher viewSwitcher) {
        this.viewSwitcher = viewSwitcher;
        String logoPath = "src/main/resources/static/loginui/LoginUI_Logo.png";
        ImageIcon titleIcon = new ImageIcon(logoPath);
        titleIcon = ImageProcessor.resizeIcon(titleIcon, 300, 100);
        setLayout(new MigLayout("insets 0, fill", "[30%]0[70%]", "[grow]"));
        JPanel leftPanel = new JPanel(new MigLayout("wrap 2", "[][grow,fill]", "[]10[]10[]10[]"));
        leftPanel.setBackground(Color.WHITE);
        leftPanel.setBorder(new EmptyBorder(20,20,20,20));
        JButton titleButton = new JButton(titleIcon);
        buttonIconFunctions(titleIcon, titleButton);
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 12));
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 12));

        leftPanel.add(titleButton, "span, align center, wrap, gaptop 100");
        leftPanel.add(usernameLabel);
        leftPanel.add(usernameField, "align center, wrap");
        leftPanel.add(passwordLabel);
        leftPanel.add(passwordField, "align center, wrap");
        this.leftPanel = leftPanel;

        String bgPath = "src/main/resources/static/loginui/LoginUI_BG.png";
        BackgroundPanel rightPanel = new BackgroundPanel(bgPath);
        rightPanel.setBackground(new Color(0xE31837));
        this.rightPanel = rightPanel;

        add(leftPanel, "grow");
        add(rightPanel, "grow");
    }

    protected void addAuthLabel(){

    }

    protected abstract void checkLogin();

    protected void addFooterLabel(JPanel panel) {
        String arrowPath = "src/main/resources/static/loginui/LoginUI_Arrow.png";
        ImageIcon buttonIcon = new ImageIcon(arrowPath);
        buttonIcon = ImageProcessor.resizeIcon(buttonIcon, 50, 50);
        JButton loginButton = new JButton(buttonIcon);
        buttonIconFunctions(buttonIcon, loginButton);
        panel.add(loginButton, "span, align center, wrap");
        JLabel footerLabel = new JLabel("version 0.1 Alpha");
        footerLabel.setFont(new Font("Arial", Font.ITALIC, 12));
        panel.add(footerLabel, "span, align center, wrap");
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

}