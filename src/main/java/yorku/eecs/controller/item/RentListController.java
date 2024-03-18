package yorku.eecs.controller.item;

import yorku.eecs.controller.ControllerError;
import yorku.eecs.logic.CsvUtil;
import yorku.eecs.model.item.Item;
import yorku.eecs.model.user.User;
import yorku.eecs.model.user.UserFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RentListController {
    /*
    Format:
    First column: User ID
    Second column: List of items the user has checked out
    Third column: Corresponding expiration dates for the list of items
    Uses rentlist.csv for data
     */
    private String path = "src/main/resources/data/rentlist.csv";

    //Creating Entry
    public void createEntry(User user) throws ControllerError {
       ArrayList<Item> rentList = user.getRentList();
       try {
            List<String> record = CsvUtil.getRecordByColumn(path, user.getStringId(), 0);
           List<List<String>> records = CsvUtil.readCsv(path);
            if (record == null) {
                //Create new entry
                List<String> newRecord = Arrays.asList(
                        user.getStringId(),
                        serializeItemList(rentList),
                        serializeExpiryList(rentList));
            } else {
                // Update previous user entry
            }
        } catch (Exception e) {
            throw new ControllerError("Error reading user", e);
        }
    }

    private String serializeExpiryList(ArrayList<Item> rentList) {

    }

    private String serializeItemList(ArrayList<Item> rentList) {
        return rentList.stream()
                .map(item -> item.getStringID())
                .collect(Collectors.joining(","));
    }

    //Reading Entry
    public void returnEntry(User user, Item returnItem) throws ControllerError {
        /* User Object rentList before -> {returnItem, other Items}
        * RentList CSV -> { returnItem, other Items}
        * return User
         */
        List<String> newRentList = new ArrayList<>();
        String id;
        try {
            List<String> record = CsvUtil.getRecordByColumn(path, user.getStringId(), 0);
            if (record == null) {
                //Create new entry
            } else {
                newRentList = record;
            }
        } catch (Exception e) {
            throw new ControllerError("Error reading user", e);
        }

        user.setRentList(newRentList);
    }

    //Return Item
    public void returnItem(User user, Item item) throws ControllerError {
        List<String> rentList = new ArrayList<>();
        String id;
        try {
            List<String> record = CsvUtil.getRecordByColumn(path, user.getStringId(), 0);
            rentList = record;
//            if (record == null) {
//                //Create new entry
//            } else {
//                rentList = record;
//            }
        } catch (Exception e) {
            throw new ControllerError("Error reading user", e);
        }

        String itemTitle = Integer.toString(item.getItemID());

    }


    // Search if the user is in the CSV, add them if they are not
    public void searchUser(User user) {
        String id = user.getStringId();
        boolean userExists = false;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split the line into columns
                String[] columns = line.split(",");

                // Check if the column at columnIndexToCheck matches the specified string
                if (columns.length > 0 && columns[0].equals(id)) {
                    // If matched, break the loop
                    userExists = true;
                    break;
                }

                // Process the current row
                // You can do something with the columns here
                //System.out.println("Row: " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
