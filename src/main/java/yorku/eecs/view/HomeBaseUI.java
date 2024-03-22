package yorku.eecs.view;

import yorku.eecs.controller.card.ViewSwitcher;
import yorku.eecs.logic.ImageProcessor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

public abstract class HomeBaseUI extends JPanel {
    protected JButton home;
    protected JButton catalog;
    protected JButton newsletter;
    protected JButton courses;
    protected JButton homeTitle;

    protected ViewSwitcher viewSwitcher;
    private JPanel sidebar;
    protected JPanel contentPanel;

    public HomeBaseUI(ViewSwitcher viewSwitcher) {
        this.viewSwitcher = viewSwitcher;
        this.setLayout(new BorderLayout());
        sidebar = new JPanel();
        contentPanel = new JPanel();

        initButtons();
        setupSidebarLayout();
        add(sidebar, BorderLayout.WEST);
        add(contentPanel, BorderLayout.CENTER);
    }

    private void initButtons() {
        Map<JButton, String> buttonIconPaths = new HashMap<>();
        home = new JButton();
        buttonIconPaths.put(home, "src/main/resources/static/sidebarui/home.png");
        catalog = new JButton();
        buttonIconPaths.put(catalog, "src/main/resources/static/sidebarui/catalog.png");
        newsletter = new JButton();
        buttonIconPaths.put(newsletter, "src/main/resources/static/sidebarui/newsletter.png");
        courses = new JButton();
        buttonIconPaths.put(courses, "src/main/resources/static/sidebarui/courses.png");

        newsletter.addActionListener(e -> actionPerformed(e.getActionCommand()));
        home.addActionListener(e -> viewSwitcher.switchView("Home"));

        // Process buttons and icons
        for (Map.Entry<JButton, String> entry : buttonIconPaths.entrySet()) {
            JButton button = entry.getKey();
            ImageIcon icon = new ImageIcon(entry.getValue());
            int width = button == homeTitle ? 150 : 50;
            int height = 50;
            ImageIcon resizedIcon = ImageProcessor.resizeIcon(icon, width, height);
            button.setIcon(resizedIcon);
            buttonIconFunctions(resizedIcon, button);
        }

        // Set up commands
        home.setActionCommand("Home");
        catalog.setActionCommand("Catalog");
        newsletter.setActionCommand("NewsLetter");
        courses.setActionCommand("Courses");
    }

    private void actionPerformed(String action) {
        if (action.equals("NewsLetter")) {
            viewSwitcher.switchView("Newsletter");
        }
    }

    private void setupSidebarLayout() {
        sidebar.setLayout(new GridLayout(4, 1));
        sidebar.add(home);
        sidebar.add(catalog);
        sidebar.add(newsletter);
        sidebar.add(courses);
        sidebar.setBackground(new Color(0xD3D3D3));
        sidebar.setPreferredSize(new Dimension(150, getHeight()));
    }
    protected void buttonIconFunctions(ImageIcon icon, JButton button) {
        button.setBorder(null);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusable(false);
        ImageIcon darkenedIcon = ImageProcessor.darkenImageIcon(icon, 0.5f);

        // Button Hover Effects
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setIcon(darkenedIcon);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                button.setIcon(icon);
            }
        });
    }
}
