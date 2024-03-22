package yorku.eecs.logic;

import yorku.eecs.model.user.User;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class UserTableModel extends AbstractTableModel {
    private final String[] columnNames = {"User Data"};
    private final ArrayList<User> users;

    public UserTableModel(ArrayList<User> users) {
        this.users = users;
    }

    @Override
    public int getRowCount() {
        return users.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        User user = users.get(rowIndex);
        if (columnIndex == 0) {
            return "YorkID: "+ user.getStringId() + " | Username: "+ user.getUserName() + " | First Name: " + user.getFirstName() + " | Last Name: " + user.getLastName();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public User getUserAt(int selectedRow) {
        return users.get(selectedRow);
    }

    public void removeUserAt(int selectedRow) {
        users.remove(selectedRow);
        fireTableRowsDeleted(selectedRow, selectedRow);
    }
}
