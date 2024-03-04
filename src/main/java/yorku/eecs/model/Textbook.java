package yorku.eecs.model;

public class Textbook extends Book{

    private String edition;

    public Textbook(Builder builder){
        super(builder);
        this.edition = builder.edition;
    }

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
