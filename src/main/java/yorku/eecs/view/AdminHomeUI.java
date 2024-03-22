package yorku.eecs.view;

import yorku.eecs.controller.card.ViewSwitcher;

import javax.swing.*;
import java.awt.*;

public class AdminHomeUI extends BaseAdminUI {
    public AdminHomeUI(ViewSwitcher viewSwitcher) {
        super(viewSwitcher);
        setupContentPanel();
    }

    @Override
    protected void setupContentPanel() {
        contentPanel.add(new JLabel("Welcome to Admin Home!"), BorderLayout.CENTER);
    }
}
