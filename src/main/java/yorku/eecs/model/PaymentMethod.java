package yorku.eecs.model;

public abstract class PaymentMethod {
    private boolean validate;
    private boolean invoiced;

    public boolean getValidate() {
        return validate;
    }
    public void setValidate(boolean validate) {
        this.validate = validate;
    }
    public void setInvoiced(boolean invoiced) {
        this.invoiced = invoiced;
    }
    public boolean getInvoiced() {
        return invoiced;
    }
}
