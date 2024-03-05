package yorku.eecs.model;

import java.util.ArrayList;

public class RentCart extends Cart{
    public RentCart() {}

    @Override
    public void checkout() {
        System.out.println("Checkout: PurchaseCart");
    }
}
