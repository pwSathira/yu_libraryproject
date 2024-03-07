package yorku.eecs.model.item;

import java.util.List;

public class Book extends Item{

    private String ISBN;

    public Book(Builder builder){
        super(builder);
        this.ISBN = builder.ISBN;
    }
    //getter
    public String getISBN() { return this.ISBN; }
    //setter
    public void setISBN(String ISBN) { this.ISBN = ISBN; }
    //To CSV Method
    @Override
    protected void getExtraCSV(List<String> rowData) {
        rowData.add(ISBN);
    }
    public static class Builder extends Item.Builder<Builder> {
        private String ISBN;

        public Builder() {}
        public Builder ISBN(String ISBN) {
            this.ISBN = ISBN;
            return self();
        }
        public Book build() {
            return new Book(this);
        }
        @Override
        protected Builder self() {
            return this;
        }
    }
}
