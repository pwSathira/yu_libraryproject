package yorku.eecs.controller.item;

import yorku.eecs.controller.ControllerError;
import yorku.eecs.logic.CsvUtil;
import yorku.eecs.logic.FilePath;
import yorku.eecs.model.item.Item;
import yorku.eecs.model.item.ItemFactory;
import yorku.eecs.logic.CSVError;

import java.util.List;
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
            System.out.println("Deleting item: " + item.getItemID());
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
}
