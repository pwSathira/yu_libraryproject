package yorku.eecs.controller;

import yorku.eecs.model.User;

public interface ViewSwitcher {
    void switchView(String viewName);
    void setUser(User user);

}
