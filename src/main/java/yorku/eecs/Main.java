package yorku.eecs;

import yorku.eecs.controller.ControllerError;
import yorku.eecs.controller.item.ItemController;
import yorku.eecs.controller.item.RentListController;
import yorku.eecs.model.cart.PurchaseCart;
import yorku.eecs.model.item.Book;
import yorku.eecs.model.item.Magazine;
import yorku.eecs.model.user.Student;
import yorku.eecs.model.user.Visitor;
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
                .itemID(10000)
                .build();

        Magazine magazine = new Magazine.Builder()
                .ISSN("!@#")
                .itemName("ello")
                .price(1)
                .location("Test")
                .publisher("Test")
                .quantity(20)
                .itemID(10002)
                .build();
        Visitor visitor = new Visitor("100000000", "password");
        visitor.getRentList().add(magazine);
        RentListController rentListController = new RentListController();
        System.out.println("Visitor: " + visitor.getId() + " " + visitor.getPassword());
        rentListController.createEntry(visitor, book);





    }





    //vin was here
}