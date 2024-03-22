package yorku.eecs;

import yorku.eecs.controller.ControllerError;
import yorku.eecs.controller.item.ItemController;
import yorku.eecs.controller.item.RentListController;
import yorku.eecs.controller.user.UserController;
import yorku.eecs.model.cart.PurchaseCart;
import yorku.eecs.model.item.Book;
import yorku.eecs.model.item.Item;
import yorku.eecs.model.item.Magazine;
import yorku.eecs.model.user.Student;
import yorku.eecs.model.user.Visitor;
import yorku.eecs.view.MainUI;
import yorku.eecs.model.item.CD_DVD;

import java.sql.Array;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) throws ControllerError {


        System.out.println("YorkU booting...");
        MainUI main = MainUI.getSingleton();
        CD_DVD cdDvd = new CD_DVD.Builder()
                .UPC("Test")
                .itemName("Test")
                .price(1)
                .location("Test")
                .publisher("Test")
                .quantity(20)
                .itemID(10004)
                .build();

        Book book = new Book.Builder()
                .ISBN("ISBN")
                .itemName("NAME")
                .price(1)
                .location("LOCATION")
                .publisher("PUBLISHER")
                .quantity(20)
                .expiryDate("DATE")
                .itemID(100000000)
                .build();

        Magazine magazine = new Magazine.Builder()
                .ISSN("!@#")
                .itemName("ello")
                .price(1)
                .location("Test")
                .publisher("Test")
                .quantity(20)
                .itemID(300000000)
                .build();
        Visitor visitor = new Visitor("400000001", "password");
//        UserController userController = new UserController();
//        userController.createUser(visitor);
        RentListController rentListController = new RentListController();
        rentListController.createEntry(visitor, book);
        rentListController.createEntry(visitor, magazine);
        rentListController.checkEntry(visitor);





    }





    //vin was here
}