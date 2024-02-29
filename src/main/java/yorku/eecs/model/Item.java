package yorku.eecs.model;

public abstract class Item {

    private int itemID;
    private String itemName;
    private String location;
    private String publisher;
    private int price;
    private boolean isRentable;
    private boolean isPurchasable;
    private boolean isDiscounted;

    public Item(){
    }

    public Item(String itemName, String location, String publisher, int price, boolean isRentable, boolean isPurchasable, boolean isDiscounted){
        this.isPurchasable = isPurchasable;
        this.itemName = itemName;
        this.isRentable = isRentable;
        this.price = price;
        this.location = location;
        this.publisher = publisher;
        this.isDiscounted = isDiscounted;
    }

    //getters
    public int getItemID(){ return this.itemID; }
    public String getItemName() { return this.itemName; }

    public String getLocation() { return this.location; }

    public String getPublisher() { return this.publisher; }

    public int getPrice() { return this.price; }

    public boolean getIsRentable() { return this.isRentable; }

    public boolean getIsPurchasable() { return this.isPurchasable; }

    //setters
    public void setItemID(int itemID){ this.itemID = itemID; }

    public void setItemName(String itemName) { this.itemName = itemName; }

    public void setLocation(String location){ this.location = location; }

    public void setPublisher(String publisher) { this.publisher = publisher; }
    public void setPrice(int price){ this.price = price; }

    public void setIsRentable(boolean isRentable){ this.isRentable = isRentable; }

    public void setIsPurchasable(boolean isPurchasable){this. isPurchasable = isPurchasable; }

    public void setDiscounted(boolean isDiscounted){
       this.isDiscounted = isDiscounted;
    }
    public boolean getIsDiscounted(){
        return isDiscounted;
    }
}
