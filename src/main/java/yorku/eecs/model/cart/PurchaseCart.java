package yorku.eecs.model.cart;

import yorku.eecs.model.item.Item;

import java.util.ArrayList;

public class PurchaseCart extends Cart{
    ArrayList<Item> items = new ArrayList<Item>();

    public PurchaseCart() {}

    @Override
    public void checkout() {
        System.out.println("Checkout: PurchaseCart");
    }
}
