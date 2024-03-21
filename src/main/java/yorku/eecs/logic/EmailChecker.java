package yorku.eecs.logic;

public class EmailChecker {
    private String email;
    public EmailChecker(String email){
        this.email = email;
    }

    public void setEmail(String password){
        this.email = email;
    }
    public String getEmail(){
        return this.email;
    }

    public static boolean checkLength(String email){
        boolean validLength = false;
        if(email.length() > 6 && email.length() <= 25){
            validLength = true;
        }
        return validLength;
    }

    public static boolean containsAtAndDotCom(String email){
        boolean container = false;
        boolean dotcom = false;
        boolean atTheRate = false;
        if(email == null){
            return false;
        }
        for(int i = 0; i < email.length(); i++){
            if(email.charAt(i) == '@'){
                atTheRate = true;
                for(int j = i; j < email.length(); j++){
                    if(email.substring(j).contains(".com")){
                        dotcom = true;
                        container = dotcom && atTheRate;
                        return container;
                    }
                    return container;
                }
            }
        }
        return container;
    }
    public static boolean mailCheck(String email){
        try {
            if(email == null){
                return false;
            }
            else if(checkLength(email) && containsAtAndDotCom(email)){
                return true;
            }
            else{
                return false;
            }
        }
        catch (Exception e){
            System.err.println("Invalid Email" + e.getMessage());
            return false;
        }
    }
}
