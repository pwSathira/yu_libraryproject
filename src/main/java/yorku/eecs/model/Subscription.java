package yorku.eecs.model;

public class Subscription {

    private double price;
    private int durationDays;
    private PaymentMethod paymentMethod;

    public Integer getDuration() {
        return durationDays;
    }

    public double getPrice () {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }




}
