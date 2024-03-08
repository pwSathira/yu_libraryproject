package yorku.eecs.logic;

public class PasswordChecker {
    private String password;

    public PasswordChecker(String password){
        this.password = password;
    }

    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return this.password;
    }

    public boolean checkStrength(String password){
        try{
            for(int i = 0; i < password.length(); i++){
                if(password.charAt(i) == password.charAt(i+1) && password.charAt(i+1) == password.charAt(i+2)){
                    return false;
                }
            }
            if(password.length()<8 && password.length() > 20){
                return false;
            }
            else{
                return true;
            }
        } catch (Exception e){
            System.err.println("An error occurred: " + e.getMessage());
            return false;
        }
    }
}
