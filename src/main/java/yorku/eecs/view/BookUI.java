package yorku.eecs.view;

import yorku.eecs.controller.card.ViewSwitcher;

import javax.swing.*;

public class BookUI extends JPanel {
    private ViewSwitcher viewSwitcher;

    public BookUI(ViewSwitcher viewSwitcher) {
        this.viewSwitcher = viewSwitcher;
        initializeUI();
    }

    private void initializeUI() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JLabel("Login Details"));
        JButton backButton = new JButton("Back to Boot");
        backButton.addActionListener(e -> viewSwitcher.switchView("Boot"));
        add(backButton);
    }
}
