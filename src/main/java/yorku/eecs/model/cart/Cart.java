package yorku.eecs.model.cart;

import yorku.eecs.model.item.Item;

import java.util.ArrayList;

public abstract class Cart {

    ArrayList<Item> items = new ArrayList<Item>();

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item);

    public void checkout();
}
