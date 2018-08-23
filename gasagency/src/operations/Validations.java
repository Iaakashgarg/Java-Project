package operations;


public class Validations {
     public static boolean isEmpty(String value) {
        if (value != null) {
            return value.trim().isEmpty();
        }
        return false;
    }
     public static boolean isEmpty(int value) {
         String v = String.valueOf(value);
        if (v != null) {
            return v.trim().isEmpty();
        }
        return false;
    }

    public static boolean isNumeric(String value) {
        try {
            if (value != null) {
                Integer.parseInt(value.trim());
                return true;
            }
        } catch (NumberFormatException ex) {
        }
        return false;
    }
    
     public static boolean onlyCharacter(String value){
        if(value!=null){
            return value.matches("^([a-zA-z.'\\s]{2,50})$");
        }
        return false;
    }
    
    public static boolean validEmail(String value){
        if(value!=null){
            return value.matches("\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
        }
        return false;
    }
    public static boolean validContact(String value){
        if(value!=null && value.length() == 10){
            for( int i = 0; i < value.length(); i++){
                if(!Character.isDigit(value.charAt(i))){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
