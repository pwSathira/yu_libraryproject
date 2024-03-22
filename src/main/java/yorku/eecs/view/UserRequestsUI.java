package yorku.eecs.view;

import yorku.eecs.controller.card.ViewSwitcher;
import yorku.eecs.controller.user.AdminController;
import yorku.eecs.controller.user.UserController;
import yorku.eecs.logic.UserTableModel;
import yorku.eecs.model.user.User;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class UserRequestsUI extends BaseAdminUI {
    private UserController userController;
    private JTable userTable;
    private UserTableModel userModel;

    public UserRequestsUI(ViewSwitcher viewSwitcher) {
        super(viewSwitcher);
        this.userController = new UserController();
        setupUI();
    }

    private void setupUI() {
        setupContentPanel();
        setupActionPanel();
    }

    @Override
    protected void setupContentPanel() {
        ArrayList<User> users = userController.getAdminQueue();
        userModel = new UserTableModel(users);
        userTable = new JTable(userModel);

        JScrollPane scrollPane = new JScrollPane(userTable);
        contentPanel.add(scrollPane, BorderLayout.CENTER);
    }

    private void setupActionPanel() {
        JPanel actionPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JButton approveButton = new JButton("Approve Selected");
        approveButton.addActionListener(e -> approveSelectedUser());

        JButton denyButton = new JButton("Deny Selected");
        denyButton.addActionListener(e -> denySelectedUser());

        actionPanel.add(approveButton);
        actionPanel.add(denyButton);

        contentPanel.add(actionPanel, BorderLayout.SOUTH);
    }

    private void approveSelectedUser() {
        int selectedRow = userTable.getSelectedRow();
        if (selectedRow >= 0) {
            User user = userModel.getUserAt(selectedRow);
            userController.approveUser(user, "dumb");
            JOptionPane.showMessageDialog(this, "Approved: " + user.toString());
        }
    }

    private void denySelectedUser() {
        int selectedRow = userTable.getSelectedRow();
        if (selectedRow >= 0) {
            User user = userModel.getUserAt(selectedRow);
            userController.removeFromAdminQueue(user);
            userModel.removeUserAt(selectedRow);
            JOptionPane.showMessageDialog(this, "Denied: " + user.toString());
        }
    }
}
