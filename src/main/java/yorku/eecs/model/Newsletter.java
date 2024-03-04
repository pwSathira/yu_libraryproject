package yorku.eecs.model;

public class Newsletter {

    private String newsLetterName;
    private String articleTitle;
    private String url;
    public void loadFrame(String url) {
    }

    public Boolean validateSubscription (Subscription subscription) {

        return true;
    }

    public String getUrl() {
        return url;
    }

    public String setUrl() {
        return this.url;
    }






}
