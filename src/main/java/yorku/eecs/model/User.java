package yorku.eecs.model;
import java.util.ArrayList;

public abstract class User {
    //SignUp class embedded into User class for simplicity
    private String userName;
    private String firstName;
    private String lastName;
    private String password;
    private int id;
    private String emailAddress;

    private ArrayList<Item> curRented = new ArrayList<>();

    //public Cart rentCart = new Cart();

    //public Cart purchaseCart = new Cart();

    public User() {
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    //get first Name
    public String getFirstName() {
        return firstName;
    }

    //get Last Name
    public String getLastName() {
        return lastName;
    }

    //get user's User Name
    public String getUserName() {
        return userName;
    }

    //get User Password
    public String getPassword(){
        return password;
    }

    public String getEmailAddress(){
        return emailAddress;
    }

}
