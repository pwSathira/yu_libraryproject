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

        JFXPanel jfxPanel = new JFXPanel();
        initFX(jfxPanel);

        contentPanel.setLayout(new BorderLayout());
        contentPanel.add(jfxPanel, BorderLayout.CENTER);
    }

    private void initFX(JFXPanel jfxPanel) {
        Platform.runLater(() -> {
            WebView webView = new WebView();
            webView.getEngine().load("http://www.wikipedia.com");
            Scene scene = new Scene(webView);
            jfxPanel.setScene(scene);
        });
    }
}
