package yorku.eecs.view;

import yorku.eecs.controller.card.ViewSwitcher;

import javax.swing.*;
import java.awt.*;

public abstract class BaseAdminUI extends JPanel {
    protected ViewSwitcher viewSwitcher;
    protected JPanel contentPanel;

    public BaseAdminUI(ViewSwitcher viewSwitcher) {
        this.viewSwitcher = viewSwitcher;
        setLayout(new BorderLayout());

        // Create side panel with buttons
        JPanel sidePanel = new JPanel();
        sidePanel.setLayout(new GridLayout(4, 1, 5, 5));
        sidePanel.add(createButton("User Requests", "UserRequests"));
        sidePanel.add(createButton("Manage Users", "ManageUsers"));
        sidePanel.add(createButton("Item Requests", "ItemRequests"));
        sidePanel.add(createButton("Manage Items", "ManageItems"));

        add(sidePanel, BorderLayout.WEST);
        contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        add(contentPanel, BorderLayout.CENTER);
    }

    private JButton createButton(String label, String viewName) {
        JButton button = new JButton(label);
        button.addActionListener(e -> viewSwitcher.switchView(viewName));
        return button;
    }
    protected abstract void setupContentPanel();
}
