package yorku.eecs.view;

import yorku.eecs.controller.card.ViewSwitcher;
import javax.swing.*;
import java.awt.*;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebView;

public class HomeUI extends HomeBaseUI {

    public HomeUI(ViewSwitcher viewSwitcher) {
        super(viewSwitcher);
        setupContentPanel();
    }

    private void setupContentPanel() {
        
    }

}
