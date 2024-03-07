package yorku.eecs.logic;

public enum FilePath {
    COURSELIST("src/main/resources/data/courselist.csv"),
    ITEMDATA("src/main/resources/data/itemdata.csv"),
    RENTLIST("src/main/resources/data/rentlist.csv"),
    STUDENTDATA("src/main/resources/data/studentdata.csv"),
    SUBSCRIPTIONDATA("src/main/resources/data/subscriptiondata.csv"),
    USERDATA("src/main/resources/data/userdata.csv");

    private String path;

    private FilePath(String path) {
        this.path = path;
    }
    public String getPath() {
        return this.path;
    }
}
