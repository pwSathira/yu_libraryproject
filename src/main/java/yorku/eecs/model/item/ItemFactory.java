package yorku.eecs.model.item;

import java.util.List;

public class ItemFactory {
    public static Item createItem(String itemType, List<String> record) {
        Item item = null;
        switch (itemType) {
            case "Book":
                item = new Book.Builder().build();
                break;
            case "CD_DVD":
                item = new CD_DVD.Builder().build();
                break;
            case "Magazine":
                item = new Magazine.Builder().build();
                break;
            case "Textbook":
                item = new Textbook.Builder().build();
                break;
            default:
                throw new IllegalArgumentException("Unknown item type: " + itemType);
        }
        item.setItemID(Integer.parseInt(record.get(0)));
        item.setItemName(record.get(1));
        item.setLocation(record.get(2));
        item.setPublisher(record.get(3));
        item.setPrice(Integer.parseInt(record.get(4)));
        item.setQuantity(Integer.parseInt(record.get(5)));
        item.setExpiryDate(record.get(6));
        return item;
    }
    public static Item updateItem(Item item, List<String> record) {
        String itemType = item.getClass().getSimpleName();
        updateGeneralRecord(item, record);
        switch (itemType) {
            case "Book":
                Book book = (Book) item;
                record.set(7, book.getISBN());
                break;
            case "CD_DVD":
                CD_DVD cd_dvd = (CD_DVD) item;
                record.set(7, cd_dvd.getUPC());
                break;
            case "Magazine":
                Magazine magazine = (Magazine) item;
                record.set(7, magazine.getISSN());
                break;
            case "Textbook":
                Textbook textbook = (Textbook) item;
                record.set(7, textbook.getISBN());
                record.set(8, textbook.getEdition());
                break;
            default:
                throw new IllegalArgumentException("Unknown item type: " + itemType);
        }
        return item;
    }

    private static void updateGeneralRecord(Item item, List<String> record) {
        record.set(0, Integer.toString(item.getItemID()));
        record.set(1, item.getItemName());
        record.set(2, item.getLocation());
        record.set(3, item.getPublisher());
        record.set(4, Integer.toString(item.getPrice()));
        record.set(5, Integer.toString(item.getQuantity()));
        record.set(6, item.getExpiryDate());
    }




}
