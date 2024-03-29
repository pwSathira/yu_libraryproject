package yorku.eecs.model.payment;

import yorku.eecs.model.payment.PaymentMethod;

public class Subscription {

    private double price;
    private int durationDays;
    private String url;
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


    public String getUrl() {
        return new String(this.url);
    }

    public void setUrl(String url) {
        this.url = new String(url);
    }
}
