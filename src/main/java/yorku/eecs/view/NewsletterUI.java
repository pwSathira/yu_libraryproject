package yorku.eecs.view;

import yorku.eecs.controller.item.NewsletterController;
import yorku.eecs.controller.card.ViewSwitcher;

import java.util.List;
import javax.swing.*;
import java.awt.*;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import yorku.eecs.model.user.User;

public class NewsletterUI extends HomeBaseUI {

    protected JButton NYTimes;
    protected JButton unsubNYTimes;
    protected JButton guardian;
    protected JButton unsubGuardian;
    protected JButton bloomberg;
    protected JButton unsubBloomberg;

    protected ViewSwitcher viewSwitcher;
    private JFXPanel jfxPanel;
    private User user;


    public NewsletterUI(ViewSwitcher viewSwitcher) {
        super(viewSwitcher);
        user = viewSwitcher.getUser();
        jfxPanel = new JFXPanel();
        initializeUI();
        contentPanel.add(jfxPanel, BorderLayout.CENTER);
    }

    private void initializeUI() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        NewsletterController newsletterController = new NewsletterController();
        user = newsletterController.getSubscribeList(user);
        List<String> subscriptions = user.getSubscribedList();
        //List<String> subscriptions = newsletterController.getSubscriptions("100000000");

        NYTimes = new JButton("Subscribe to NYTimes");
        unsubNYTimes = new JButton("Unsub from NYTimes");
        guardian = new JButton("Subscribe to Guardian");
        unsubGuardian = new JButton("Unsub from Guardian");
        bloomberg = new JButton("Subscribe to Bloomberg");
        unsubBloomberg = new JButton("Unsub from Bloomberg");

        NYTimes.setActionCommand("NYTimes");
        unsubNYTimes.setActionCommand("NYTimes");
        guardian.setActionCommand("Guardian");
        unsubGuardian.setActionCommand("Guardian");
        bloomberg.setActionCommand("Bloomberg");
        unsubBloomberg.setActionCommand("Bloomberg");

        NYTimes.addActionListener(e -> initFX(jfxPanel, e.getActionCommand()));
        unsubNYTimes.addActionListener(e -> unsubscribe(user, e.getActionCommand()));
        guardian.addActionListener(e -> initFX(jfxPanel, e.getActionCommand()));
        unsubGuardian.addActionListener(e -> unsubscribe(user, e.getActionCommand()));
        bloomberg.addActionListener(e -> initFX(jfxPanel, e.getActionCommand()));
        unsubBloomberg.addActionListener(e -> unsubscribe(user, e.getActionCommand()));

        contentPanel.add(NYTimes);
        contentPanel.add(unsubNYTimes);
        contentPanel.add(guardian);
        contentPanel.add(unsubGuardian);
        contentPanel.add(bloomberg);
        contentPanel.add(unsubBloomberg);
        unsubNYTimes.setVisible(subscriptions.contains("NYTimes"));
        unsubGuardian.setVisible(subscriptions.contains("Guardian"));
        unsubBloomberg.setVisible(subscriptions.contains("Bloomberg"));
        if (subscriptions.contains("NYTimes")) {
            NYTimes.setText("Visit NYTimes");
        }
        if (subscriptions.contains("Guardian")) {
            guardian.setText("Visit Guardian");
        }
        if (subscriptions.contains("Bloomberg")) {
            bloomberg.setText("Visit Bloomberg");
        }
    }

    private void initFX(JFXPanel jfxPanel, String website) {
        NewsletterController newsletterController = new NewsletterController();
        Platform.runLater(() -> {
            WebView webView = new WebView();
            if (website.equals("NYTimes")) {
                NYTimes.setText("Visit NYTimes");
                unsubNYTimes.setVisible(true);
                webView.getEngine().load("https://www.nytimes.com/");
            }
            else if (website.equals("Guardian")) {
                guardian.setText("Visit Guardian");
                unsubGuardian.setVisible(true);
                webView.getEngine().load("https://www.theguardian.com/international");
            }
            else if (website.equals("Bloomberg")) {
                bloomberg.setText("Visit Bloomberg");
                unsubBloomberg.setVisible(true);
                webView.getEngine().load("https://www.bloomberg.com/canada");
            }
            newsletterController.subscribe(user, website);
            //newsletterController.subscribe("100000000", website);

            Scene scene = new Scene(webView);
            jfxPanel.setScene(scene);
        });
    }

    private void unsubscribe(User user, String newsletter) {
        NewsletterController newsletterController = new NewsletterController();
        if(newsletter.equals("NYTimes")) {
            unsubNYTimes.setVisible(false);
            NYTimes.setText("Subscribe to NYTimes");
        }
        else if (newsletter.equals("Guardian")) {
            unsubGuardian.setVisible(false);
            guardian.setText("Subscribe to Guardian");
        }
        else if (newsletter.equals("Bloomberg")) {
            unsubNYTimes.setVisible(false);
            bloomberg.setText("Subscribe to Bloomberg");
        }
        else {
            System.out.println("Error unsubscribing from newsletter.");
        }
        newsletterController.unsubscribe(user, newsletter);
    }

}