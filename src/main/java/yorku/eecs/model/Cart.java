package yorku.eecs.model;

import java.util.ArrayList;

public class Cart {
    private ArrayList<Item> items = new ArrayList<Item>();

    public Cart() {
    }
    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public void checkout() {
        System.out.println("Checkout: Cart");
    }
}
