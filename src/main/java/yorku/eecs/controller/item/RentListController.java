package yorku.eecs.controller.item;

import yorku.eecs.controller.ControllerError;
import yorku.eecs.logic.CsvUtil;
import yorku.eecs.model.item.Item;
import yorku.eecs.model.user.User;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDate;
import java.util.Date;
import java.util.Calendar;

public class RentListController {
    /*
    Format:
    First column: User ID
    Second column: List of items the user has checked out
    Uses rentlist.csv for data
     */
    private String path = "src/main/resources/data/rentlist.csv";
    /*
    Current plan for CSV:
    Column 1: Item ID
    Column 2: List of user IDs that have rented item
    Column 3: List of expiration dates, mapped to the users by index
     */

    public boolean checkItemExists(Item item) {
        return true;
    }

    public boolean checkAvailability(Item item) {
        // Loop through users and count how many copies are checked out
        return true;
    }

    public void rentItem() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DAY_OF_MONTH, 7);
        int year = cal.get(Calendar.YEAR);
        int month = (cal.get(Calendar.MONTH))+1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
    }

    //Creating Entry
//    public void createEntry(User user, Item item) throws ControllerError {
//        //Check if user exists
//        user.getRentList().add(item);
//        try{
//            String id = user.getStringId();
//            List<String> records = CsvUtil.getRecordByColumn(path, id, 0);
//            if (records != null) {
//                //Update entry
//                List<String> modifiableRecords = new ArrayList<>();
//                modifiableRecords.add(0, user.getStringId());
//                modifiableRecords.add(1, serializeItemList(user.getRentList()));
//                CsvUtil.writeCsv(Arrays.asList(modifiableRecords), path, false);
//            } else {
//                //Create new entry
//                List<List<String>> newRecord = new ArrayList<>();
//                newRecord.add(Arrays.asList(id, serializeItemList(user.getRentList())));
//                CsvUtil.writeCsv(newRecord, path, true);
//            }
//        }catch (Exception e){
//            throw new ControllerError("Error reading user", e);
//        }
//    }
//
//    private String serializeItemList(ArrayList<Item> rentList) {
//        return rentList.stream()
//                .map(item -> item.getStringID())
//                .collect(Collectors.joining(","));
//    }
//
//    //Reading Entry
//    public void returnEntry(User user, Item returnItem) throws ControllerError {
//        /* User Object rentList before -> {returnItem, other Items}
//        * RentList CSV -> { returnItem, other Items}
//        * return User
//         */
//        List<Item> rentList = user.getRentList();
//        rentList.remove(returnItem);
//        try{
//            String id = user.getStringId();
//            List<String> records = CsvUtil.getRecordByColumn(path, id, 0);
//            if (records != null) {
//                //Update entry
//                List<String> modifiableRecords = new ArrayList<>();
//                modifiableRecords.add(0, user.getStringId());
//                modifiableRecords.add(1, serializeItemList(user.getRentList()));
//                CsvUtil.writeCsv(Arrays.asList(modifiableRecords), path, false);
//            } else {
//                //Throw error that user does not exist
//                throw new ControllerError("User does not exist");
//            }
//        }catch (Exception e){
//            throw new ControllerError("Error reading user", e);
//        }
//    }
//
//    //Return Item
//    public void checkEntry(User user) throws ControllerError {
//        try {
//            String id = user.getStringId();
//            List<String> records = CsvUtil.getRecordByColumn(path, id, 0);
//            System.out.println("Records: " + records);
//            if (records != null && !records.isEmpty()) {
//                // Skip the first element and parse the remaining strings into a list of integers
//                ArrayList<Integer> itemIds = new ArrayList<>();
//                for (int i = 1; i < records.size(); i++) { // Start from 1 to skip the ID
//                    try {
//                        itemIds.add(Integer.parseInt(records.get(i)));
//                    } catch (NumberFormatException e) {
//                        System.err.println("Error parsing record to integer: " + records.get(i));
//                    }
//                }
//                user.getRentList().clear();
//                for (int itemId : itemIds) {
//                    ItemController itemController = new ItemController();
//                    String itemType = itemController.determineItemType(Integer.toString(itemId));
//                    Item item = itemController.readItem(Integer.toString(itemId), itemType);
//                    user.getRentList().add(item);
//                }
//            } else {
//                // Throw error that user does not exist
//                throw new ControllerError("User does not exist");
//            }
//        } catch (Exception e) {
//            throw new ControllerError("Error reading user", e);
//        }
//    }
}
