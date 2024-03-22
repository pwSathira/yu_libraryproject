package yorku.eecs.view;

import yorku.eecs.controller.card.ViewSwitcher;
import yorku.eecs.controller.item.ItemController;
import yorku.eecs.logic.ItemTableModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SearchUI extends HomeBaseUI {

    private JTextField searchField = new JTextField(40);
    private JButton searchButton = new JButton("Search here");
    private JPanel displayedItems = new JPanel();

    JLabel test1 = new JLabel();

    private JLabel test = new JLabel("test");

    private ItemController itemController;

    public SearchUI(ViewSwitcher viewSwitcher) {
        super(viewSwitcher);
        init();
    }

    private void init(){
        itemController = new ItemController();
        searchButton.setActionCommand("Search");
        searchButton.addActionListener(e -> actionPerformed(e.getActionCommand()));
        contentPanel.add(searchField);
        contentPanel.add(searchButton);
        contentPanel.add(displayedItems);
    }

    private void actionPerformed(String actionCommand) {

        if (actionCommand.equals("Search")) {
            String userInput = searchField.getText().trim();
            System.out.println("PRESSED SEARCH BUTTON");
            System.out.println("User input: " + userInput);
            performSearch(userInput);
        }
    }

    private void performSearch(String userInput){
        displayedItems.removeAll();
        ArrayList<String> items;
        items = itemController.recommendItem(userInput);
        ItemTableModel itemTableModel = new ItemTableModel(items);
        JTable itemTable = new JTable(itemTableModel);
        JScrollPane scrollPane = new JScrollPane(itemTable);
        displayedItems.add(scrollPane, BorderLayout.CENTER);
        displayedItems.validate();
        displayedItems.repaint();
        contentPanel.add(displayedItems);
        contentPanel.validate();
        contentPanel.repaint();
    }
}





















