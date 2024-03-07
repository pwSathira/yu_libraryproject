package yorku.eecs;

import yorku.eecs.controller.ControllerError;
import yorku.eecs.controller.UserController;
import yorku.eecs.model.*;
import yorku.eecs.view.MainUI;
import yorku.eecs.model.CD_DVD;

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
                .isRentable(true)
                .isPurchasable(true)
                .isDiscounted(false)
                .build();

        Book book = new Book.Builder()
                .ISBN("!@#")
                .itemName("ello")
                .price(1)
                .location("Test")
                .publisher("Test")
                .isRentable(true)
                .isPurchasable(true)
                .isDiscounted(false)
                .build();

        Magazine magazine = new Magazine.Builder()
                .ISSN("!@#")
                .itemName("ello")
                .price(1)
                .location("Test")
                .publisher("Test")
                .isRentable(true)
                .isPurchasable(true)
                .isDiscounted(false)
                .build();

        PurchaseCart purchaseCart = new PurchaseCart();
        PurchaseCart cart = new PurchaseCart();
        cart.checkout();

        UserController userController = new UserController();
        Student user = (Student) userController.readUser("200000000", "Student");
        System.out.println(user.getUserName());



    }
    //vin was here
}