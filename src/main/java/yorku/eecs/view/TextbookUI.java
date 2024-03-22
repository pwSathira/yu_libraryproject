package yorku.eecs.view;

import javafx.embed.swing.JFXPanel;
import yorku.eecs.controller.card.ViewSwitcher;

import java.awt.*;

public class TextbookUI extends HomeBaseUI {

    protected ViewSwitcher viewSwitcher;
    private JFXPanel jfxPanel;
    private String path = "src/main/resources/data/newsletterdata.csv";
    
    public TextbookUI(ViewSwitcher viewSwitcher) {
        super(viewSwitcher);
        jfxPanel = new JFXPanel();
        initializeUI();
        contentPanel.add(jfxPanel, BorderLayout.CENTER);
    }

    private void initializeUI() {
    }
}
