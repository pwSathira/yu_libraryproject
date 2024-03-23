//package yorku.eecs.model.cart;
//
//import yorku.eecs.model.item.Item;
//import yorku.eecs.model.payment.PaymentMethod;
//
//import java.util.ArrayList;
//
//public class PurchaseCart implements Cart{
//    ArrayList<Item> items = new ArrayList<Item>();
//
//    private PaymentMethod paymentMethod;
//
//    public PurchaseCart() {}
//
//    //Getters
//    public PaymentMethod getPaymentMethod() { return this.paymentMethod; }
//
//    //Setters
//    public void setPaymentMethod(PaymentMethod paymentMethod) { this.paymentMethod = paymentMethod; }
//
//    public void addItem(Item item) {
//        items.add(item);
//    }
//
//    public void removeItem(Item item) {
//        items.remove(item);
//    }
//
//    public int getTotal(){
//        int total = 0;
//        for (Item item: items) {
//            total += item.getPrice();
//        }
//        return total;
//    }
//    @Override
//    public void checkout() {
//        paymentMethod.pay(this.getTotal());
//        items.clear();
//    }
//
//
//}
