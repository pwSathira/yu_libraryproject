package yorku.eecs.model.user;
import yorku.eecs.model.cart.RentCart;
import yorku.eecs.model.item.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private ArrayList<String> subscribedList = new ArrayList<>();

    public User() {
    }

    public User(String id, String password) {
        this.id=Integer.parseInt(id);
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
    public ArrayList<String> getSubscribedList() {return subscribedList;}
    public ArrayList<Item> getRentList() {return rentList;}

    //SETTERS
    public void setUserName(String userName) {this.userName = userName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}
    public void setLastName(String lastName) {this.lastName = lastName;}
    public void setPassword(String password) {this.password = password;}
    public void setId(int id) {this.id = id;}
    public void setEmailAddress(String emailAddress) {this.emailAddress = emailAddress;}
    public void setSubscribedList(ArrayList<String> subscribedList) {this.subscribedList = subscribedList;}
    public void setRentList(ArrayList<Item> rentList) {this.rentList = rentList;}

    public List<List<String>> toCSV(int id) {
        List<List<String>> data = new ArrayList<>();
        List<String> row = new ArrayList<>();
        row.add(Integer.toString(id));
        row.add(getUserName());
        row.add(getFirstName());
        row.add(getLastName());
        row.add(getEmailAddress());
        row.add(getPassword());
        data.add(row);
        return data;
    }
}
