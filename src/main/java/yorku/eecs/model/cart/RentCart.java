package yorku.eecs.model.cart;

public class RentCart extends Cart{
    public RentCart() {}

    @Override
    public void checkout() {
        System.out.println("Checkout: PurchaseCart");
    }
}
