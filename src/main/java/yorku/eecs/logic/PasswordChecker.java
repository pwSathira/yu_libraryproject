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

    public static boolean checkRepetitions(String password){
        //Checks for 3 consecutive repetitions
        boolean noRepetitions = false;
        for(int i = 0; i < password.length(); i++){
            if(password.charAt(i) != password.charAt(i+1) && password.charAt(i+1) != password.charAt(i+2)){
                noRepetitions = true;
                return noRepetitions;
            }
        }
        return noRepetitions;
    }

    public static boolean checkUpperCase(String password){
        // Checks if String contains atleast 1 upper case
        boolean containUpperCase = false;
        for(char letter : password.toCharArray()){
            if(Character.isUpperCase(letter)){
                containUpperCase = true;
                return containUpperCase;
            }
        }
        return containUpperCase;
    }

    public static boolean checkLowerCase(String password){
        // Checks if String contains atleast 1 lower case
        boolean containLowerCase = false;
        for(char letter : password.toCharArray()){
            if(Character.isLowerCase(letter)){
                containLowerCase = true;
                return containLowerCase;
            }
        }
        return containLowerCase;
    }

    public static boolean checkDigit(String password){
        // Checks if String contains atleast 1 digit
        boolean containDigit = false;
        for(char letter : password.toCharArray()){
            if(Character.isDigit(letter)){
                containDigit = true;
                return containDigit;
            }
        }
        return containDigit;
    }

    public static boolean checkLength(String password){
        // Checks for password length
        boolean passwordLength = false;
        if(password.length() > 7){
            passwordLength = true;
            return passwordLength;
        }
        return passwordLength;
    }

    public static boolean checkStrength(String password){
        try{
            if(checkLength(password) && checkDigit(password) && checkRepetitions(password) && checkLowerCase(password) && checkUpperCase(password)){
                return true;
            }
            else {
                return false;
            }
        }
        catch (Exception e){
            System.err.println("Not Strong: " + e.getMessage());
            return false;
        }
    }
}
