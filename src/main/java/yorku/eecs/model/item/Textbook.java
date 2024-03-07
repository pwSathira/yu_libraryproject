package yorku.eecs.model.item;
import java.util.List;
public class Textbook extends Book{

    private String edition;

    public Textbook(Builder builder){
        super(builder);
        this.edition = builder.edition;
    }

    //getter
    public String getEdition() { return this.edition; }
    //setter
    public void setEdition(String edition) { this.edition = edition; }
    //To CSV Method
    @Override
    protected void getExtraCSV(List<String> rowData) {rowData.add(edition);}

    public static class Builder extends Book.Builder{
        private String edition;
        public Builder(){
            super();
        }
        public Builder edition(String edition){
            this.edition = edition;
            return this;
        }
        public Textbook build(){
            return new Textbook(this);
        }
        @Override
        protected Builder self() {
            return this;
        }
    }
}
