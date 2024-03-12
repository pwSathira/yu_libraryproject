package yorku.eecs.view;

import yorku.eecs.controller.card.ViewSwitcher;
import yorku.eecs.logic.BackgroundPanel;
import yorku.eecs.logic.IdField;

import javax.swing.*;

public class NavBarUI extends JPanel {
    protected ViewSwitcher viewSwitcher;
    protected IdField idField;
    protected JPanel topPanel;
    //protected BackgroundPanel rightPanel;

    public NavBarUI(ViewSwitcher viewSwitcher) {
        this.viewSwitcher = viewSwitcher;
        //addGeneralLayout();
        //add(leftPanel, "grow");
        //add(rightPanel, "grow");
    }
}
