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

    //currently rented out
    private ArrayList<Item> rentList = new ArrayList<>();

    //currently subscribed items
    private ArrayList<Item> subscribedList = new ArrayList<>();

    public User() {
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    //GETTERS
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getUserName() {
        return userName;
    }
    public String getPassword(){
        return password;
    }
    public String getEmailAddress(){
        return emailAddress;
    }
    public int getId() {
        return id;
    }
    public String getStringId() {return Integer.toString(id);}
    public ArrayList<Item> getSubscribedList() {return subscribedList;}
    public ArrayList<Item> getRentList() {return rentList;}

    //SETTERS
    public void setUserName(String userName) {this.userName = userName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}
    public void setLastName(String lastName) {this.lastName = lastName;}
    public void setPassword(String password) {this.password = password;}
    public void setId(int id) {this.id = id;}
    public void setEmailAddress(String emailAddress) {this.emailAddress = emailAddress;}
    public void setSubscribedList(ArrayList<Item> subscribedList) {this.subscribedList = subscribedList;}
    public void setRentList(ArrayList<Item> rentList) {this.rentList = rentList;}

}
