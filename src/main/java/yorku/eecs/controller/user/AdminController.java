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
    /*
     * CRUD Operations for Item Model
     */
    //create new item
    public Item createItem(Item item) throws ControllerError {
        return itemController.createItem(item);
    }
    //public Item readItem
    public void readItem(String id, String type) throws ControllerError{
        itemController.readItem(id, type);
    }
    public void updateItem(Item item) throws  ControllerError{
        itemController.updateItem(item);
    }
    // Deletes item
    public void deleteItem(Item item) throws ControllerError{
        itemController.deleteItem(item);
    }
    /*
     * CRUD Operations for User Model
     */
    // Create a new user
    public User createUser(User user) throws ControllerError {
        return userController.createUser(user);
    }
    // Read an existing user
    public User readUser(String id, String type) throws ControllerError {
        return userController.readUser(id, type);
    }
    // Update an existing user
    public void updateUser(User user) throws ControllerError {
        userController.updateUser(user);
    }
    // Delete an existing user
    public void deleteUser(User user) throws ControllerError {
        userController.deleteUser(user);
    }
    // Determine user type
    public String determineUserType(String id) {
        return userController.determineUserType(id);
    }

    public boolean authenticateUser(User userDB, User userInput) {
        return userController.authenticateUser(userDB, userInput);
    }


}
