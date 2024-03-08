package yorku.eecs.model.payment;

public interface PaymentMethod {

    public void pay(int total);
    public void getPaymentDetails();

}
