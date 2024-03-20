package yorku.eecs.model.user;

public class Admin extends User {
    public Admin() {
        super();
    }
    public Admin(int id, String userName, String firstName, String lastName, String emailAddress, String password) {
        super(Integer.toString(id),password);
    }
}
