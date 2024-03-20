package yorku.eecs.view;

import net.miginfocom.swing.MigLayout;
import yorku.eecs.controller.card.ViewSwitcher;
import yorku.eecs.logic.BackgroundPanel;
import yorku.eecs.logic.IdField;
import yorku.eecs.logic.ImageProcessor;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import yorku.eecs.model.user.User;

public class NewsletterUI extends HomeBaseUI implements Subject {

    protected JButton NYTimes;
    protected JButton guardian;
    protected JButton bloomberg;

    protected ViewSwitcher viewSwitcher;
    private JPanel sidebar;
    private JFXPanel jfxPanel;

    private ArrayList<Observer> observerList = new ArrayList<>();

    public NewsletterUI(ViewSwitcher viewSwitcher) {
        super(viewSwitcher);
        jfxPanel = new JFXPanel();
        initializeUI();
        contentPanel.add(jfxPanel, BorderLayout.CENTER);
    }

    private void initializeUI() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        NYTimes = new JButton("Subscribe");
        guardian = new JButton("Subscribe");
        bloomberg = new JButton("Subscribe");

        NYTimes.setActionCommand("NYTimes");
        guardian.setActionCommand("Guardian");
        bloomberg.setActionCommand("Bloomberg");

        NYTimes.addActionListener(e -> initFX(jfxPanel, e.getActionCommand()));
        guardian.addActionListener(e -> initFX(jfxPanel, e.getActionCommand()));
        bloomberg.addActionListener(e -> initFX(jfxPanel, e.getActionCommand()));

        contentPanel.add(NYTimes);
        contentPanel.add(guardian);
        contentPanel.add(bloomberg);
    }

    private void initFX(JFXPanel jfxPanel, String website) {
        Platform.runLater(() -> {
            WebView webView = new WebView();
            if (website.equals("NYTimes")) {
                webView.getEngine().load("https://www.nytimes.com/");
                NYTimes.setText("Go to Website");
            }
            else if (website.equals("Guardian")) {
                webView.getEngine().load("https://www.theguardian.com/international");
                guardian.setText("Go to Website");
            }
            else if (website.equals("Bloomberg")) {
                webView.getEngine().load("https://www.bloomberg.com/canada");
                bloomberg.setText("Go to Website");
            }
            Scene scene = new Scene(webView);
            jfxPanel.setScene(scene);
        });
    }

    public void addObserver(User user){

    }

    public void removeObserver(User user) {

    }
    public void notifyObservers() {

    }

}
