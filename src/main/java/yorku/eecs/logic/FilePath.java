package yorku.eecs.logic;

public enum FilePath {
    COURSELIST("src/main/resources/data/courselist.csv"),
    ITEMDATA("src/main/resources/data/bookdata.csv"),
    RENTLIST("src/main/resources/data/rentlist.csv"),
    STUDENTDATA("src/main/resources/data/studentdata.csv"),
    SUBSCRIPTIONDATA("src/main/resources/data/subscriptiondata.csv"),
    USERDATA("src/main/resources/data/userdata.csv"),
    VISITORDATA("src/main/resources/data/visitordata.csv"),
    FACULTYDATA("src/main/resources/data/facultydata.csv"),
    NONFACULTYDATA("src/main/resources/data/nonfacultydata.csv");

    private String path;
    private FilePath(String path) {
        this.path = path;
    }
    public String getPath() {
        return this.path;
    }
}
