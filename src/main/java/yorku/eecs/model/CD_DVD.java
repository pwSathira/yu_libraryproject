package yorku.eecs.model;

public class CD_DVD extends Item{

    private String UPC;

    public CD_DVD(String UPC){
        this.UPC = UPC;
    }
    //getter
    public String getUPC() { return this.UPC; }

    //setter
    public void setUPC() { this.UPC = UPC;}
}
