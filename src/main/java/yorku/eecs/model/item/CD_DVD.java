package yorku.eecs.model.item;

import java.util.List;
//Concrete Builder

public class CD_DVD extends Item{

    private String UPC;

    public CD_DVD(Builder builder){
        super(builder);
        this.UPC = builder.UPC;
    }
    //getter
    public String getUPC() { return this.UPC; }

    //setter
    public void setUPC(String UPC) { this.UPC = UPC; }

    //To CSV Method
    @Override
    protected void getExtraCSV(List<String> rowData) {
        rowData.add(UPC);
    }

    public static class Builder extends Item.Builder<Builder> {
        private String UPC;

        public Builder() {
            super();
        }
        public Builder UPC(String UPC) {
            this.UPC = UPC;
            return self();
        }
        public CD_DVD build() {
            return new CD_DVD(this);
        }
        @Override
        protected Builder self() {
            return this;
        }
    }
}
