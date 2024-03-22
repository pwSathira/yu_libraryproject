package yorku.eecs.controller.user;

import yorku.eecs.controller.ControllerError;
import yorku.eecs.logic.CSVError;
import yorku.eecs.logic.CsvUtil;
import yorku.eecs.logic.FilePath;
import yorku.eecs.model.item.Item;
import yorku.eecs.model.user.User;
import yorku.eecs.model.user.UserFactory;

import java.util.ArrayList;
import java.util.List;
/*
* CRUD Operations for User Model
 */
public class UserController {
    User user;
    private String path;
    //Create a user, and assign id
    public User createUser(User user) throws ControllerError {
        this.user = user;
        setPathBasedOnUserType(user);
        try {
            String currentId = CsvUtil.getLastInstanceByColumn(path, 0);
            assert currentId != null;
            int id = Integer.parseInt(currentId) + 1;
            user.setId(id);
            CsvUtil.writeCsv(user.toCSV(id), path, true);
            return user;
        } catch (Exception e) {
            throw new ControllerError("User creation failed");
        }
    }

    //Update a user
    public void updateUser(User user) throws ControllerError{
        setPathBasedOnUserType(user);
        try {
            List<String> record = CsvUtil.getRecordByColumn(path, user.getStringId(), 0);
            assert record != null;
            record.set(0, user.getUserName());
            record.set(1, user.getFirstName());
            record.set(2, user.getLastName());
            record.set(3, user.getPassword());
            record.set(4, user.getEmailAddress());
            CsvUtil.writeCsv(user.toCSV(user.getId()), path, false);
        } catch (Exception e) {
            throw new ControllerError("User update failed");
        }
    }
    //Read a user
    public User readUser(String id, String userType) throws ControllerError{
        setPathBasedOnUserType(userType);
        try {
            List<String> record = CsvUtil.getRecordByColumn(path, id, 0);
            if (record == null) {
                throw new ControllerError("User not found");
            }
            return UserFactory.createUser(userType, record);
        } catch (Exception e) {
            throw new ControllerError("Error reading user", e);
        }
    }
    //Delete a user
    public void deleteUser(User user) throws ControllerError {
        setPathBasedOnUserType(user);
        try {
            List<List<String>> records = CsvUtil.readCsv(path);
            records.removeIf(record -> record.get(0).equals(user.getStringId()));
            CsvUtil.writeCsv(records, path, false);
        } catch (CSVError e) {
            throw new ControllerError("User deletion failed", e);
        }
    }

    //User Requests New Item
    public void requestNewItem(Item item) throws ControllerError {
        //TODO requirement 9 from deliverable 1
    }

    //Set the path based on the user type
    public void setPathBasedOnUserType(Object userTypeOrClass) throws ControllerError {
        String userType;
        if (userTypeOrClass instanceof String) {
            userType = (String) userTypeOrClass;
        } else if (userTypeOrClass instanceof User) {
            userType = userTypeOrClass.getClass().getSimpleName();
        } else {
            throw new ControllerError("Invalid user type or class");
        }

        switch (userType) {
            case "Visitor":
                this.path = FilePath.VISITORDATA.getPath();
                break;
            case "Faculty":
                this.path = FilePath.FACULTYDATA.getPath();
                break;
            case "NonFaculty":
                this.path = FilePath.NONFACULTYDATA.getPath();
                break;
            case "Student":
                this.path = FilePath.STUDENTDATA.getPath();
                break;
            default:
                throw new ControllerError("User type not found: " + userType);
        }
    }
    //Print the records
    public void printRecords(List<String> records) {
        for (String record : records) {
            System.out.println(record);
        }
    }

    public boolean checkUserExists(User user) throws ControllerError {
        setPathBasedOnUserType(user);
        try {
            // Check if YorkID is taken
            List<String> recordById = CsvUtil.getRecordByColumn(path, user.getStringId(), 0);
            if (recordById != null && !recordById.isEmpty()) {
                return true; // YorkID is taken
            }

            // Check if Username is taken
            List<String> recordByUsername = CsvUtil.getRecordByColumn(path, user.getUserName(), 1);
            if (recordByUsername != null && !recordByUsername.isEmpty()) {
                return true; // Username is taken
            }

            // Check if Email is taken
            List<String> recordByEmail = CsvUtil.getRecordByColumn(path, user.getEmailAddress(), 4);
            if (recordByEmail != null && !recordByEmail.isEmpty()) {
                return true; // Email is taken
            }

            // If none of the fields match, then the user does not exist in the database
            return false;
        } catch (Exception e) {
            throw new ControllerError("Checking if user exists failed", e);
        }
    }

    public String determineUserType(String id){
        if(id.startsWith("1")){
            return "Faculty";
        }else if(id.startsWith("2")){
            return "Student";
        }else if(id.startsWith("3")){
            return "NonFaculty";
        }else if(id.startsWith("4")){
            return "Visitor";
        }
        return null;
    }

    public boolean authenticateUser(User userDB, User userInput) {
        boolean id = userDB.getStringId().equals(userInput.getStringId());
        boolean password = userDB.getPassword().equals(userInput.getPassword());
        return password && id;
    }

    public void addToAdminQueue(User user) {
        try {
            CsvUtil.writeCsv(user.toCSV(user.getId()), FilePath.ADMINQUEUEDATA.getPath(), true);
        } catch (CSVError e) {
            e.printStackTrace();
        }
    }

    public void removeFromAdminQueue(User user) {
        try {
            List<List<String>> records = CsvUtil.readCsv(FilePath.ADMINQUEUEDATA.getPath());
            records.removeIf(record -> record.get(0).equals(user.getStringId()));
            CsvUtil.writeCsv(records, FilePath.ADMINQUEUEDATA.getPath(), false);
        } catch (CSVError e) {
            e.printStackTrace();
        }
    }

    public void approveUser(User user, String userType) {
        try {
            setPathBasedOnUserType(userType);
            CsvUtil.writeCsv(user.toCSV(user.getId()), path, true);
            removeFromAdminQueue(user);
        } catch (CSVError | ControllerError e) {
            e.printStackTrace();
        }
    }

    public ArrayList<User> getAdminQueue() {
        ArrayList<User> users = new ArrayList<>();
        try {
            List<List<String>> records = CsvUtil.readCsv(FilePath.ADMINQUEUEDATA.getPath());
            for (List<String> record : records) {
                String userType = determineUserType(record.get(0));
                users.add(UserFactory.createUser(userType, record));
            }
        } catch (CSVError e) {
            e.printStackTrace();
        }
        return users;
    }
}
