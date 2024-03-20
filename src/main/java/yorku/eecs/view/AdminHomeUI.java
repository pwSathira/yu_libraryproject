package yorku.eecs.view;

import yorku.eecs.controller.card.ViewSwitcher;

import javax.swing.*;

public class AdminHomeUI extends JPanel {
    ViewSwitcher viewSwitcher;
    public AdminHomeUI(ViewSwitcher viewSwitcher) {
        this.viewSwitcher = viewSwitcher;
        add(new JLabel("Admin Home"));
    }
}
