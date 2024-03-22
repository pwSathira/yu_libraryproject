package yorku.eecs.view;

import yorku.eecs.controller.card.ViewSwitcher;
import yorku.eecs.controller.item.ItemController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RequestNewBookUI extends HomeBaseUI {

    private JTextField searchField = new JTextField(40);
    private JButton searchButton = new JButton("Search here");
    private JPanel displayedItems = new JPanel(new GridLayout(3,3));

    JLabel test1 = new JLabel();

    private JLabel test = new JLabel("test");

    private ItemController itemController;

    public RequestNewBookUI(ViewSwitcher viewSwitcher) {
        super(viewSwitcher);
        init();
    }

    private void init(){
        itemController = new ItemController();


        searchButton.setActionCommand("search");
        searchButton.addActionListener(e -> actionPerformed(e.getActionCommand()));
        contentPanel.add(searchField);

        contentPanel.add(searchButton);


       /* searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userInput = searchField.getText().trim();
                performSearch(userInput);
            }
        });
        */
    }

    private void actionPerformed(String actionCommand) {

        if (actionCommand.equals("search")) {
            searchButton.setText("hello");
            String userInput = searchField.getText().trim();
            performSearch(userInput);
        }
    }

    private void performSearch(String userInput){
        displayedItems.removeAll();
        ArrayList<String> items = new ArrayList<>();
        items = itemController.recommendItem(userInput);




        for (int i = 0; i < items.size(); i++) {
            test1.setText(items.get(i));
            contentPanel.add(test1);
        }



        displayedItems.revalidate();
        displayedItems.repaint();
    }
}





















