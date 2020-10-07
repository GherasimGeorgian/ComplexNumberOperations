package Model;

public class Utils {
    public static boolean isInteger(String s){
        try{
            Integer.parseInt(s);
        }
        catch(NumberFormatException e){
            return false;
        }
        catch(NullPointerException e){
            return false;
        }
        return true;
    }
    public static long countOccurrences(String occurrences, char findChar){
        return  occurrences.chars().filter( x -> {
            return x == findChar;
        }).count();
    }
}
