package yorku.eecs.view;

import yorku.eecs.controller.card.ViewSwitcher;

public class LoginUI extends AuthBaseUI {
    public LoginUI(ViewSwitcher viewSwitcher) {
        super(viewSwitcher);
        addFooterLabel(this.leftPanel);
    }

    @Override
    protected void checkLogin() {
    }
}