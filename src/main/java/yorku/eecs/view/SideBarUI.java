package yorku.eecs.view;

import net.miginfocom.swing.MigLayout;
import yorku.eecs.logic.BackgroundPanel;
import yorku.eecs.logic.ImageProcessor;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class SideBarUI extends JPanel {

    protected JButton home;
    protected JButton catalog;
    protected JButton newsletter;
    protected JButton courses;

    private JPanel leftPanel;
    private JPanel rightPanel;

    public SideBarUI(MainUI mainUI){
        addGeneralLayout();
        initButtons();
        add(leftPanel, "growy");
        add(rightPanel, "grow");
    }

    private void initButtons(){

        home = new JButton();
        catalog = new JButton();
        newsletter = new JButton();
        courses = new JButton();

        ImageIcon homeIcon = new ImageIcon("src/main/resources/static/sidebarui/home.png");
        ImageIcon catalogIcon = new ImageIcon("src/main/resources/static/sidebarui/catalog.png");
        ImageIcon newsletterIcon = new ImageIcon("src/main/resources/static/sidebarui/newsletter.png");
        ImageIcon coursesIcon = new ImageIcon("src/main/resources/static/sidebarui/courses.png");

        homeIcon = ImageProcessor.resizeIcon(homeIcon, 200,50);
        catalogIcon = ImageProcessor.resizeIcon( catalogIcon, 200,50);
        newsletterIcon = ImageProcessor.resizeIcon(newsletterIcon,200,50);
        coursesIcon = ImageProcessor.resizeIcon(coursesIcon,200,50);

        home.setIcon(homeIcon);
        catalog.setIcon(catalogIcon);
        newsletter.setIcon(newsletterIcon);
        courses.setIcon(coursesIcon);


        home.setActionCommand("Home");
        catalog.setActionCommand("Catalog");
        newsletter.setActionCommand("NewsLetter");
        courses.setActionCommand("Courses");

        this.leftPanel.add(home, "growx");
        this.leftPanel.add(catalog, "growx");
        this.leftPanel.add(newsletter, "growx");
        this.leftPanel.add(courses, "growx");

    }

    protected void addGeneralLayout(){
        setLayout(new MigLayout("debug, insets 0, fill", "[30%]0[70%]", "[grow]"));
        JPanel leftPanel = new JPanel(new MigLayout("wrap 2", "[][grow,fill]", "[]10[]10[]10[]"));
        leftPanel.setBackground(Color.WHITE);
        leftPanel.setBorder(new EmptyBorder(20,20,20,20));
        String bgPath = "src/main/resources/static/loginui/LoginUI_BG.png";
        BackgroundPanel rightPanel = new BackgroundPanel(bgPath);
        rightPanel.setBackground(new Color(0xE31837));
        this.leftPanel = leftPanel;
        this.rightPanel = rightPanel;
    }




}