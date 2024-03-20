package yorku.eecs.view;

public interface Subject {
    public void addObserver(User user);
    public void removeObserver(User user);
    public void notifyObservers();
}
