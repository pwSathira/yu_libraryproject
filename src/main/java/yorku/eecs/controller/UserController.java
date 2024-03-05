package yorku.eecs.controller;

import yorku.eecs.logic.CsvUtil;
import yorku.eecs.model.User;

public class UserController {

    public static boolean login(String username, String password) {
        try {
            return CsvUtil.readCsv("src/main/resources/data/userdata.csv").stream()
                    .anyMatch(record -> record.get(0).equals(username) && record.get(1).equals(password));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static User getUser(String username) {
        try {
//            return CsvUtil.readCsv("src/main/resources/data/userdata.csv").stream()
//                    .filter(record -> record.get(0).equals(username))
//                    .map(record -> new User(record.get(0), record.get(1)))
//                    .findFirst()
//                    .orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean validateEnrollment (String name, String role) {
        // Name will be the user's name in the university's database
        // role will be their role in the university (student, non-faculty, faculty etc.)
        try {
            return CsvUtil.readCsv("src/main/resources/data/enrollmentdata.csv").stream()
                    .anyMatch(record -> record.get(0).equals(name) && record.get(1).equals(role));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
