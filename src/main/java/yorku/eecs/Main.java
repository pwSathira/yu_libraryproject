package yorku.eecs;

import yorku.eecs.controller.ControllerError;
import yorku.eecs.model.cart.PurchaseCart;
import yorku.eecs.model.item.Book;
import yorku.eecs.model.item.Magazine;
import yorku.eecs.view.MainUI;
import yorku.eecs.model.item.CD_DVD;

public class Main {
    public static void main(String[] args) throws ControllerError {
        System.out.println("YorkU booting...");
        MainUI main = new MainUI();
        CD_DVD cdDvd = new CD_DVD.Builder()
                .UPC("Test")
                .itemName("Test")
                .price(1)
                .location("Test")
                .publisher("Test")
                .quantity(20)
                .build();

        Book book = new Book.Builder()
                .ISBN("!@#")
                .itemName("ello")
                .price(1)
                .location("Test")
                .publisher("Test")
                .quantity(20)
                .build();

        Magazine magazine = new Magazine.Builder()
                .ISSN("!@#")
                .itemName("ello")
                .price(1)
                .location("Test")
                .publisher("Test")
                .quantity(20)
                .build();

        PurchaseCart purchaseCart = new PurchaseCart();
        PurchaseCart cart = new PurchaseCart();
        cart.checkout();
    }
    //vin was here
}