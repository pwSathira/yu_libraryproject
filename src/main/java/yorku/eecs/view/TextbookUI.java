package yorku.eecs.view;

import javafx.embed.swing.JFXPanel;
import yorku.eecs.controller.card.ViewSwitcher;

import java.awt.*;

public class TextbookUI extends HomeBaseUI {
    public TextbookUI(ViewSwitcher viewSwitcher) {
        super(viewSwitcher);
        jfxPanel = new JFXPanel();
        initializeUI();
        contentPanel.add(jfxPanel, BorderLayout.CENTER);
    }
}
