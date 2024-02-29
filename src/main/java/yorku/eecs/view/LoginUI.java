package yorku.eecs.view;

import yorku.eecs.controller.ViewSwitcher;

import javax.swing.*;

public class LoginUI extends AuthBaseUI {
    public LoginUI(ViewSwitcher viewSwitcher) {
        super(viewSwitcher);
        addFooterLabel(this.leftPanel);
    }

    @Override
    protected void checkLogin() {
    }
}