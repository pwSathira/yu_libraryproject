package yorku.eecs.controller.card;

import yorku.eecs.model.user.User;

public interface ViewSwitcher {
    void switchView(String viewName);
    void setUser(User user);

}
