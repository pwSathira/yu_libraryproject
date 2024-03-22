package yorku.eecs.view;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import yorku.eecs.controller.card.ViewSwitcher;

import javax.swing.*;
import java.awt.*;

public class TextbookUI extends HomeBaseUI {

    protected ViewSwitcher viewSwitcher;
    private JFXPanel jfxPanel;
    private String path = "src/main/resources/PDFs/Deliverable-2.pdf";
    protected JButton test;
    
    public TextbookUI(ViewSwitcher viewSwitcher) {
        super(viewSwitcher);
        jfxPanel = new JFXPanel();
        initializeUI();
        contentPanel.add(jfxPanel, BorderLayout.CENTER);
    }

    private void initializeUI() {

        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        test = new JButton("test pdf");
        test.setActionCommand("test");
        test.addActionListener(e -> initFX(jfxPanel, e.getActionCommand()));
        contentPanel.add(test);
    }

    private void initFX(JFXPanel jfxPanel, String actionCommand) {
        Platform.runLater(() -> {
            WebView webView = new WebView();
            webView.getEngine().load("src/main/resources/PDFs/Deliverable-2.pdf");
            Scene scene = new Scene(webView);
            jfxPanel.setScene(scene);
        });
    }
}
