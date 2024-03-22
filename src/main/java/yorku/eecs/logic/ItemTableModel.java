package yorku.eecs.logic;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ItemTableModel extends AbstractTableModel {
private final String[] columnNames = {"Item Data"};
    private final ArrayList<String> items;

    public ItemTableModel(ArrayList<String> items) {
        this.items = items;
        System.out.println("ItemTableModel created");
    }

    @Override
    public int getRowCount() {
        return items.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String item = items.get(rowIndex);
        if (columnIndex == 0) {
            System.out.println("ItemTableModel getValueAt");
            return "Item Name: "+ item;
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

    public String getItemAt(int selectedRow) {
        return items.get(selectedRow);
    }

    public void removeItemAt(int selectedRow) {
        items.remove(selectedRow);
        fireTableRowsDeleted(selectedRow, selectedRow);
    }
}
