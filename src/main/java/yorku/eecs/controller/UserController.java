package yorku.eecs.controller;

import yorku.eecs.logic.CSVError;
import yorku.eecs.logic.CsvUtil;
import yorku.eecs.logic.FilePath;
import yorku.eecs.model.*;

import java.util.List;
/*
* CRUD Operations for Student Model
 */
public class UserController {
    User user;
    private String path;

    public void createStudent(User user) throws ControllerError{
        this.user = user;
        setPathBasedOnUserType(user);
        try {
            String currentId = CsvUtil.getLastInstanceByColumn(path, 0);
            assert currentId != null;
            currentId = Integer.toString(Integer.parseInt(currentId) + 1);
            CsvUtil.writeCsv(user.toCSV(user.getId()), path, true);
        } catch (Exception e) {
            throw new ControllerError("User creation failed");
        }
    }
    public void updateStudent(User user) throws ControllerError{
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
    public void deleteStudent(User user) throws ControllerError {
        setPathBasedOnUserType(user);
        try {
            List<List<String>> records = CsvUtil.readCsv(path);
            records.removeIf(record -> record.get(0).equals(user.getStringId()));
            CsvUtil.writeCsv(records, path, false);
        } catch (CSVError e) {
            throw new ControllerError("User deletion failed", e);
        }
    }
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
    public void printRecords(List<String> records) {
        for (String record : records) {
            System.out.println(record);
        }
    }
}
