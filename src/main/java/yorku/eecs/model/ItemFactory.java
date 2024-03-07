package yorku.eecs.model;

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
        item.setIsRentable(Boolean.parseBoolean(record.get(5)));
        item.setIsPurchasable(Boolean.parseBoolean(record.get(6)));
        item.setIsDiscounted(Boolean.parseBoolean(record.get(7)));
        item.setQuantity(Integer.parseInt(record.get(8));

        return item;
    }
}
