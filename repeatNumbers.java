import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by icons on 26.2.17.
 */
public class repeatNumbers {
    public static void main (String []args){
        String[] str = {"1", "2", "2", "3"};
        for (int i= 0; i<str.length; i++) {
            System.out.print(" " + str [i]);
        }
        Set<String> set = new HashSet<String>(Arrays.asList(str));
        String[] result = set.toArray(new String[set.size()]);
        for (int i= 0; i<str.length-1; i++) {
            System.out.print(" " + result [i]);
        }

    }

}