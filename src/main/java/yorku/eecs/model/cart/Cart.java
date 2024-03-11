package yorku.eecs.model.cart;

import yorku.eecs.model.item.Item;

import java.util.ArrayList;

public interface Cart {
    ArrayList<Item> items = new ArrayList<Item>();

    public void addItem(Item item);

    public void removeItem(Item item);

    public void checkout();
}
