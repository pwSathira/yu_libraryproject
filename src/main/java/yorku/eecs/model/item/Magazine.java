package yorku.eecs.model.item;

import java.util.List;

public class Magazine extends Item {

    private String ISSN;

    public Magazine(Builder builder){
        super(builder);
        this.ISSN = builder.ISSN;
    }
    //getter
    public String getISSN() { return this.ISSN; }

    //setter
    public void setISSN(String ISSN) { this.ISSN = ISSN; }

    //To CSV Method
    @Override
    protected void getExtraCSV(List<String> rowData) {
        rowData.add(ISSN);
    }

    public static class Builder extends Item.Builder<Builder> {
        private String ISSN;

        public Builder() {
            super();
        }
        public Builder ISSN(String ISSN) {
            this.ISSN = ISSN;
            return self();
        }
        public Magazine build() {
            return new Magazine(this);
        }
        @Override
        protected Builder self() {
            return this;
        }
    }
}
