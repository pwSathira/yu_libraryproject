package yorku.eecs.model;

import java.util.List;

public class UserFactory {
    public static User createUser(String userType, List<String> record) {
        User user = null;
        switch (userType) {
            case "Student":
                user = new Student();
                break;
            case "Faculty":
                user = new Faculty();
                break;
            case "NonFaculty":
                user = new NonFaculty();
                break;
            case "Visitor":
                user = new Visitor();
                break;
            default:
                throw new IllegalArgumentException("Unknown user type: " + userType);
        }
        user.setId(Integer.parseInt(record.get(0)));
        user.setUserName(record.get(1));
        user.setFirstName(record.get(2));
        user.setLastName(record.get(3));
        user.setEmailAddress(record.get(4));
        user.setPassword(record.get(5));
        return user;
    }
}
