package yorku.eecs.model;

public interface CartType {
    void addItem(Item item);
    void removeItem(Item item);
    void checkout();
}
