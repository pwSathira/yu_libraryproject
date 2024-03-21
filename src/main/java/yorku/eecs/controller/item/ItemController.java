package yorku.eecs.controller.item;

import yorku.eecs.controller.ControllerError;
import yorku.eecs.logic.CSVError;
import yorku.eecs.logic.CsvUtil;
import yorku.eecs.logic.FilePath;
import yorku.eecs.model.item.Item;
import yorku.eecs.model.item.ItemFactory;


import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

/*
 * CRUD Operations for Item Model
 */
public class ItemController {
    String itemType;
    private String path;

    //Create an item, and assign id
    public Item createItem(Item item) throws ControllerError {
        setPathBasedOnItemType(item);
        try {
            String currentId = CsvUtil.getLastInstanceByColumn(path, 0);
            assert currentId != null;
            int id = Integer.parseInt(currentId) + 1;
            item.setItemID(id);
            CsvUtil.writeCsv(item.toCSV(id), path, true);
            return item;
        } catch (Exception e) {
            throw new ControllerError("Item creation failed");
        }
    }
    //Update an item
    public void updateItem(Item item) throws ControllerError{
        setPathBasedOnItemType(item);
        try {
            List<String> record = CsvUtil.getRecordByColumn(path, item.getStringId(), 0);
            assert record != null;
            ItemFactory.updateItem(item, record);
            CsvUtil.writeCsv(item.toCSV(item.getItemID()), path, false);
        } catch (Exception e) {
            throw new ControllerError("Item update failed");
        }
    }
    //Read an item
    public Item readItem(String id, String itemType) throws ControllerError{
        setPathBasedOnItemType(itemType);
        try {
          List<String> record = CsvUtil.getRecordByColumn(path, id, 0);
          if (record != null) {return ItemFactory.createItem(itemType, record);}
        } catch (Exception e) {
            throw new ControllerError("Error reading item", e);
        }
        return null;
    }
    //Delete an item
    public void deleteItem(Item item) throws ControllerError {
        setPathBasedOnItemType(item);
        try {
            List<List<String>> records = CsvUtil.readCsv(path);
            records.removeIf(record -> record.get(0).equals(item.getStringId()));
            CsvUtil.writeCsv(records, path, false);
        } catch (CSVError e) {
            throw new ControllerError("Item deletion failed", e);
        }
    }
    //Set the path based on the user type
    public void setPathBasedOnItemType(Object itemTypeOrClass) throws ControllerError {
        String itemType;
        if (itemTypeOrClass instanceof String) {
            itemType = (String) itemTypeOrClass;
        } else if (itemTypeOrClass instanceof Item) {
            itemType = itemTypeOrClass.getClass().getSimpleName();
        } else {
            throw new ControllerError("Invalid item type or class");
        }

        switch (itemType) {
            case "CD_DVD":
                this.path = FilePath.CD_DVDDATA.getPath();
                this.itemType = "CD_DVD";
                break;
            case "Book":
                this.path = FilePath.BOOKDATA.getPath();
                this.itemType = "Book";
                break;
            case "Magazine":
                this.path = FilePath.MAGAZINEDATA.getPath();
                this.itemType = "Magazine";
                break;
            case "Textbook":
                this.path = FilePath.TEXTBOOKDATA.getPath();
                this.itemType = "Textbook";
                break;
            default:
                throw new ControllerError("Item type not found: " + itemType);
        }
    }
    public void printRecords(List<String> records) {
        for (String record : records) {
            System.out.println(record);
        }
    }

    public String determineItemType(String id) {
        if(id.startsWith("1")){
            return "Book";
        }else if(id.startsWith("2")){
            return "CD_DVD";
        }else if(id.startsWith("3")){
            return "Magazine";
        }else if(id.startsWith("4")){
            return "Textbook";
        }
        return null;
    }

    public List<String> recommendItem(String input){
        List<String> recommendations = new ArrayList<>();

        try{
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/data/bookdata.csv"));
            String line;
            List<String> inputTokens = tokenize(input.toLowerCase());
            while((line = reader.readLine()) != null){
                String[] parts = line.split(",");
                String bookName = parts[1].toLowerCase();
                List<String> bookTokens = tokenize(bookName);
                double similarity = cosineSimilarity(inputTokens , bookTokens);
                if (similarity > 0.5){
                    recommendations.add(bookName);
//                    System.out.println(bookName);
                }
            }

            reader.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return recommendations;
    }

    public static List<String> tokenize(String text){
        List<String> tokens = new ArrayList<>();
        for(String token : text.split("\\s")){
            tokens.add(token);
        }
        return tokens;
    }

    public static double cosineSimilarity(List<String> list1, List<String> list2){
        int product = 0;
        for(String token : list1){
            if(list2.contains(token)){
                product++;
            }
        }
        double magnitude1 = Math.sqrt(list1.size());
        double magnitude2 = Math.sqrt(list2.size());
        return product / (magnitude1 * magnitude2);
    }
}




















