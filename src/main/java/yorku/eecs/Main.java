package yorku.eecs;

import yorku.eecs.model.Book;
import yorku.eecs.model.CD_DVD;
import yorku.eecs.model.Magazine;
import yorku.eecs.view.MainUI;
import yorku.eecs.model.CD_DVD;

public class Main {
    public static void main(String[] args) {
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

    }
    //vin was here
}