package yorku.eecs.view;

import yorku.eecs.controller.card.ViewSwitcher;
import yorku.eecs.controller.item.ItemController;

import javax.swing.*;
import java.awt.*;

public class RequestNewBookUI extends HomeBaseUI {

    private JTextField searchField = new JTextField(100);
    private JButton searchButton = new JButton("Search here");
    private JPanel displayedItems = new JPanel(new GridLayout(3,3));

    private ItemController itemController;

    public RequestNewBookUI(ViewSwitcher viewSwitcher) {
        super(viewSwitcher);
        itemController = new ItemController();


        JPanel searchPannel = new JPanel();
        searchPannel.add(searchField);
        searchPannel.add(searchButton);


        //searchButton.add()
    }
}
