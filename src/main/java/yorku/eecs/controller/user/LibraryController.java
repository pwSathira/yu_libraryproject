package yorku.eecs.controller.user;

import yorku.eecs.controller.ControllerError;
import yorku.eecs.controller.card.ViewSwitcher;
import yorku.eecs.logic.CSVError;
import yorku.eecs.logic.CsvUtil;
import yorku.eecs.logic.FilePath;
import yorku.eecs.model.item.Item;
import yorku.eecs.model.user.User;
import yorku.eecs.model.user.UserFactory;
import yorku.eecs.controller.ControllerError;
import yorku.eecs.controller.item.ItemController;
import yorku.eecs.model.item.Item;

public class LibraryController {
    private User user;

    public LibraryController(User user) {
        this.user = user;
    }

    public boolean checkOverdue() {

        return false;
    }

}
