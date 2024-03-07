package yorku.eecs.logic;

public enum FilePath {

    //User Data
    USERDATA("src/main/resources/data/userdata.csv"),
    STUDENTDATA("src/main/resources/data/studentdata.csv"),
    VISITORDATA("src/main/resources/data/visitordata.csv"),
    FACULTYDATA("src/main/resources/data/facultydata.csv"),
    NONFACULTYDATA("src/main/resources/data/nonfacultydata.csv"),

    //List Data
    COURSELIST("src/main/resources/data/courselist.csv"),
    RENTLIST("src/main/resources/data/rentlist.csv"),
    SUBSCRIPTIONDATA("src/main/resources/data/subscriptiondata.csv"),

    //Item Data
    BOOKDATA("src/main/resources/data/bookdata.csv"),
    CD_DVDDATA("src/main/resources/data/cddvd.csv"),
    MAGAZINEDATA("src/main/resources/data/magazinedata.csv"),
    TEXTBOOKDATA("src/main/resources/data/textbookdata.csv"); //TODO Create Textbook Data
    private String path;
    private FilePath(String path) {
        this.path = path;
    }
    public String getPath() {
        return this.path;
    }
}
