package yorku.eecs.view;

import yorku.eecs.controller.ControllerError;
import yorku.eecs.controller.card.ViewSwitcher;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

import yorku.eecs.controller.item.RentListController;
import yorku.eecs.model.item.Item;
import yorku.eecs.model.user.User;

public class HomeUI extends HomeBaseUI {
    private User user;

    public HomeUI(ViewSwitcher viewSwitcher) {
        super(viewSwitcher);
        user = viewSwitcher.getUser();
        setupContentPanel();
    }

    private void setupContentPanel() {
        try {
            RentListController rentListController = new RentListController();
            rentListController.checkEntry(user);
        } catch (ControllerError e) {
            JOptionPane.showMessageDialog(this, "RentList controller failure", "RentList", JOptionPane.ERROR_MESSAGE);
        }

        // Define column names for the table
        String[] columnNames = {"Rented Item", "Due Date"};

        // Use DefaultTableModel
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        // Populate the table model with item data
        for (Item item : user.getRentList()) {
            Object[] row = {item.getItemName(), item.getExpiryDate()};
            tableModel.addRow(row);
        }

        // Create the table with the model
        JTable table = new JTable(tableModel);

        // Make the table scrollable
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        // Add the scrollPane to this panel
        contentPanel.setLayout(new BorderLayout());
        contentPanel.add(scrollPane, BorderLayout.CENTER);
    }



}
