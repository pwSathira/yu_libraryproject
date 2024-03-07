package yorku.eecs.controller.user;

import yorku.eecs.controller.ControllerError;
import yorku.eecs.controller.item.ItemController;
import yorku.eecs.model.item.Item;
import yorku.eecs.model.user.User;



public class AdminController{
    //facade design pattern
    private ItemController itemController;
    private UserController userController;

    public AdminController() {
        this.itemController = new ItemController();
        this.userController = new UserController();
    }

    //create new item
    public Item createItem(Item item) throws ControllerError {
        return itemController.createItem(item);
    }
    // Deletes item
    public void deleteItem(Item item) throws ControllerError{
        itemController.deleteItem(item);
    }

    //public Item readItem
    public void readItem(String id, String type) throws ControllerError{
        itemController.readItem(id, type);
    }

    public void updateItem(Item item) throws  ControllerError{
        itemController.updateItem(item);
    }


    // Create a new user
    public User createUser(User user) throws ControllerError {
        return userController.createUser(user);
    }

    // Update an existing user
    public void updateUser(User user) throws ControllerError {
        userController.updateUser(user);
    }


}
