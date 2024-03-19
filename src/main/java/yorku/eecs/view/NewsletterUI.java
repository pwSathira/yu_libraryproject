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

public class NewsletterUI extends JPanel {

    private ViewSwitcher viewSwitcher;

    public NewsletterUI(ViewSwitcher viewSwitcher) {
        this.viewSwitcher = viewSwitcher;
        initializeUI();
    }

    private void initializeUI() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        JButton NYTimes = new JButton("Subscribe");
        JButton guardian = new JButton("Subscribe");
        JButton bloomberg = new JButton("Subscribe");
        add(NYTimes);
        add(guardian);
        add(bloomberg);
    }

}
