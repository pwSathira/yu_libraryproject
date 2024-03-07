package yorku.eecs.controller.card;

import yorku.eecs.model.user.User;

import java.awt.CardLayout;
import javax.swing.JPanel;

public class CardController {
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private User user;

    public CardController(JPanel cardPanel) {
        this.cardPanel = cardPanel;
        this.cardLayout = (CardLayout) cardPanel.getLayout();
    }

    public void showCard(String cardName) {
        cardLayout.show(cardPanel, cardName);
    }

    public void setUser(User user) {
        this.user = user;
    }
}
