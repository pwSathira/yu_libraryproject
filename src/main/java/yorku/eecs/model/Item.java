package yorku.eecs.model;

public abstract class Item {

    //Required Parameters
    private int itemID;
    private String itemName;
    private String location;
    private String publisher;
    private int price;

    //Optional Parameters
    private boolean isRentable;
    private boolean isPurchasable;
    private boolean isDiscounted;
    private int quantity;

    //Takes in a Builder object and sets the values of the Item object
    protected Item(Builder<?> builder) {
        this.itemID = builder.itemID;
        this.itemName = builder.itemName;
        this.location = builder.location;
        this.publisher = builder.publisher;
        this.price = builder.price;
        this.isRentable = builder.isRentable;
        this.isPurchasable = builder.isPurchasable;
        this.isDiscounted = builder.isDiscounted;
        this.quantity = builder.quantity;
    }

    //Getters of the Item object
    public int getItemID() { return this.itemID; }
    public String getItemName() { return this.itemName; }
    public String getLocation() { return this.location; }
    public String getPublisher() { return this.publisher; }
    public int getPrice() { return this.price; }
    public boolean getIsRentable() { return this.isRentable; }
    public boolean getIsPurchasable() { return this.isPurchasable; }
    public boolean getIsDiscounted() { return this.isDiscounted; }
    public int getQuantity(){return this.quantity;}
    public String getStringId() {return Integer.toString(itemID);}

    //Setters of the Item object
    public void setItemID(int itemID) { this.itemID = itemID; }
    public void setItemName(String itemName) { this.itemName = itemName; }
    public void setLocation(String location) { this.location = location; }
    public void setPublisher(String publisher) { this.publisher = publisher; }
    public void setPrice(int price) { this.price = price; }
    public void setIsRentable(boolean isRentable) { this.isRentable = isRentable; }
    public void setIsPurchasable(boolean isPurchasable) { this.isPurchasable = isPurchasable; }
    public void setIsDiscounted(boolean isDiscounted) { this.isDiscounted = isDiscounted; }
    public void setQuantity(int quantity) {this.quantity = quantity;}

    //Abstract Builder class
    //Takes in a Builder object and sets the values of the Item object
    //T is the generic type of the Builder
    public abstract static class Builder<T extends Builder<T>> {
        private int itemID;
        private String itemName;
        private String location;
        private String publisher;
        private int price;
        private boolean isRentable = false;
        private boolean isPurchasable = true;
        private boolean isDiscounted = false;

        private int quantity = 20;

        public Builder() {}

        public void itemConstructor (int itemID, String itemName, String location, String publisher, int price){
            this.itemID = itemID;
            this.itemName = itemName;
            this.location = location;
            this.publisher = publisher;
            this.price = price;
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

        public T isRentable(boolean isRentable) {
            this.isRentable = isRentable;
            return self();
        }

        public T isPurchasable(boolean isPurchasable) {
            this.isPurchasable = isPurchasable;
            return self();
        }

        public T isDiscounted(boolean isDiscounted) {
            this.isDiscounted = isDiscounted;
            return self();
        }

        public T quantity (int quantity) {
            this.quantity = quantity;
            return self();
        }

        //Abstract method that returns the Builder object
        protected abstract T self();

        //Abstract method that builds the Item object
        public abstract Item build();
    }
}