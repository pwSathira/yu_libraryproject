package yorku.eecs.model.item;

import java.util.ArrayList;
import java.util.List;

public abstract class Item {

    //Required Parameters
    private int itemID;
    private String itemName;
    private String location;
    private String publisher;
    private int price;
    private int quantity;
    private String expiryDate;

    //Takes in a Builder object and sets the values of the Item object
    protected Item(Builder<?> builder) {
        this.itemID = builder.itemID;
        this.itemName = builder.itemName;
        this.location = builder.location;
        this.publisher = builder.publisher;
        this.price = builder.price;
        this.quantity = builder.quantity;
        this.expiryDate = builder.expiryDate;
    }

    //Getters of the Item object
    public int getItemID() { return this.itemID; }
    public String getStringID(){return String.valueOf(this.itemID);}
    public String getItemName() { return this.itemName; }
    public String getLocation() { return this.location; }
    public String getPublisher() { return this.publisher; }
    public int getPrice() { return this.price; }
    public int getQuantity(){return this.quantity;}
    public String getStringId() {return Integer.toString(itemID);}
    public String getExpiryDate() { return this.expiryDate; }

    //Setters of the Item object
    public void setItemID(int itemID) { this.itemID = itemID; }
    public void setItemName(String itemName) { this.itemName = itemName; }
    public void setLocation(String location) { this.location = location; }
    public void setPublisher(String publisher) { this.publisher = publisher; }
    public void setPrice(int price) { this.price = price; }
    public void setQuantity(int quantity) {this.quantity = quantity;}
    public void setExpiryDate(String expiryDate) { this.expiryDate = expiryDate; }

    //To CSV Method
    public List<List<String>> toCSV(int id) {
        List<List<String>> csvData = new ArrayList<>();
        List<String> row = new ArrayList<>();
        row.add(Integer.toString(itemID));
        row.add(itemName);
        row.add(location);
        row.add(publisher);
        row.add(Integer.toString(price));
        row.add(Integer.toString(quantity));
        row.add(expiryDate);
        getExtraCSV(row);
        csvData.add(row);
        return csvData;
    }
    protected void getExtraCSV(List<String> rowData) {}

    //Abstract Builder class
    //Takes in a Builder object and sets the values of the Item object
    //T is the generic type of the Builder
    //Builder class
    public abstract static class Builder<T extends Builder<T>> {
        private int itemID;
        private String itemName;
        private String location;
        private String publisher;
        private String expiryDate;
        private int price;
        private int quantity = 20;
        public Builder() {}

        public void itemConstructor (int itemID, String itemName, String location, String publisher, int price, String expiryDate, int quantity){
            this.itemID = itemID;
            this.itemName = itemName;
            this.location = location;
            this.publisher = publisher;
            this.price = price;
            this.expiryDate = expiryDate;
            this.quantity = quantity;
        }

        public T itemID(int itemID) {
            this.itemID = itemID;
            return self();
        }

        public T itemName(String itemName) {
            this.itemName = itemName;
            return self();
        }

        public T location(String location) {
            this.location = location;
            return self();
        }

        public T publisher(String publisher) {
            this.publisher = publisher;
            return self();
        }

        public T price(int price) {
            this.price = price;
            return self();
        }

        public T quantity (int quantity) {
            this.quantity = quantity;
            return self();
        }

        public T expiryDate(String expiryDate) {
            this.expiryDate = expiryDate;
            return self();
        }

        //Abstract method that returns the Builder object
        protected abstract T self();

        //Abstract method that builds the Item object
        public abstract Item build();
    }
}