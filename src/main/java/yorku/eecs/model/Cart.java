package yorku.eecs.model;

import java.util.ArrayList;

public class Cart {

    private ArrayList<Item> itemList = new ArrayList<>(); // the list of items in the cart

    public void addItem(Item item) { // adds an item to the cart
        itemList.add(item);
    }

    public void removeItem(Item item) { // removes an item from the cart
        itemList.remove(item);
    }

    public void viewCart() {} //dunno yet

    public boolean checkRentCapacity() {

        int rentCount = 0;

        for (int i = 0; i < itemList.size();i++) {
            if (itemList.get(i).getIsRentable()) {
                rentCount++;
            }
        }
        //rentCount += user.getCurrentRent

        return false; }




}
