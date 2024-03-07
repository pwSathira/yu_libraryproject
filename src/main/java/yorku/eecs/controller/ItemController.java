package yorku.eecs.controller;

import yorku.eecs.logic.CSVError;
import yorku.eecs.logic.CsvUtil;
import yorku.eecs.logic.FilePath;
import yorku.eecs.model.*;

import java.util.ArrayList;
import java.util.List;
public class ItemController {
    Item item;
    private String path = "src/main/resources/data/bookdata.csv";

    public void createItem(Item item) throws ControllerError {
        this.item = item;
        checkInstanceOf(item);
        try {
            String currentId = CsvUtil.getLastInstanceByColumn(path, 0);
            assert currentId != null;
            currentId = Integer.toString(Integer.parseInt(currentId) + 1);
            List<List<String>> data = new ArrayList<>();
            List<String> row = new ArrayList<>();
            row.add(currentId);
            row.add(item.getItemName());
            row.add(item.getLocation());
            row.add(item.getPublisher());
            row.add(Integer.toString(item.getPrice()));
            row.add(Boolean.toString(item.getIsRentable()));
            row.add(Boolean.toString(item.getIsPurchasable()));
            data.add(row);
            CsvUtil.writeCsv(data, path, true);
        } catch (Exception e) {
            throw new ControllerError("Item creation failed");
        }
    }


    public void deleteItem() {

    }

    //update item
    public void updateItem(Item item) throws ControllerError {
        checkInstanceOf(item);
        try {
            List<String> itemRecord = CsvUtil.getRecordByColumn(path, item.getStringId(), 0);
            assert record != null;




        } catch (CSVError e) {
            throw new ControllerError("Error updating item", e);
        }

    }

    public void checkInstanceOf(Item item) {

    }

}
