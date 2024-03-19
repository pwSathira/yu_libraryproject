package yorku.eecs.view;

import yorku.eecs.controller.card.ViewSwitcher;
import yorku.eecs.logic.ImageProcessor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public abstract class HomeBaseUI extends JPanel {
    protected JButton home;
    protected JButton catalog;
    protected JButton newsletter;
    protected JButton courses;
    protected JButton homeTitle;

    protected ViewSwitcher viewSwitcher;
    private JPanel sidebar; // Panel for sidebar buttons
    protected JPanel contentPanel; // Panel for displaying the main content

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
        home = new JButton();
        catalog = new JButton();
        newsletter = new JButton();
        courses = new JButton();
        homeTitle = new JButton();
        ImageIcon homeIcon = new ImageIcon("src/main/resources/static/sidebarui/home.png");
        ImageIcon catalogIcon = new ImageIcon("src/main/resources/static/sidebarui/catalog.png");
        ImageIcon newsletterIcon = new ImageIcon("src/main/resources/static/sidebarui/newsletter.png");
        ImageIcon coursesIcon = new ImageIcon("src/main/resources/static/sidebarui/courses.png");
        ImageIcon homeTitleIcon = new ImageIcon("src/main/resources/static/loginui/LoginUI_Logo.png");
        homeIcon = ImageProcessor.resizeIcon(homeIcon, 50, 50);
        catalogIcon = ImageProcessor.resizeIcon(catalogIcon, 50, 50);
        newsletterIcon = ImageProcessor.resizeIcon(newsletterIcon, 50, 50);
        coursesIcon = ImageProcessor.resizeIcon(coursesIcon, 50, 50);
        homeTitleIcon = ImageProcessor.resizeIcon(homeTitleIcon, 150, 50);
        home.setIcon(homeIcon);
        catalog.setIcon(catalogIcon);
        newsletter.setIcon(newsletterIcon);
        courses.setIcon(coursesIcon);
        homeTitle.setIcon(homeTitleIcon);
        buttonIconFunctions(homeIcon, home);
        buttonIconFunctions(catalogIcon, catalog);
        buttonIconFunctions(newsletterIcon, newsletter);
        buttonIconFunctions(coursesIcon, courses);
        buttonIconFunctions(homeTitleIcon, homeTitle);
        // Setup commands, similar to your original implementation
        home.setActionCommand("Home");
        catalog.setActionCommand("Catalog");
        newsletter.setActionCommand("NewsLetter");
        courses.setActionCommand("Courses");
        homeTitle.setActionCommand("Home");
    }

    private void setupSidebarLayout() {
        sidebar.setLayout(new GridLayout(5, 1));
        sidebar.add(homeTitle);
        sidebar.add(home);
        sidebar.add(catalog);
        sidebar.add(newsletter);
        sidebar.add(courses);
        sidebar.setBackground(new Color(0xD3D3D3));
        sidebar.setPreferredSize(new Dimension(200, getHeight()));
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
