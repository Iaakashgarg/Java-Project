/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package operational;

/**
 *
 * @author Grapess
 */
public class Checks {
    public static boolean isEmpty(String value){
        return value.trim().equals("");
    }
    public static boolean isNumeric(String value){
        try{
            Integer.parseInt(value);
            return true;
        }catch(Exception ex){
            return false;
        }
    }
    
    public static boolean isFloatNumeric(String value){
        try{
            Float.parseFloat(value);
            return true;
        }catch(Exception ex){
            return false;
        }
    }
}
