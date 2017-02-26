/**
 * Created by icons on 26.2.17.
 */
public class cycleArray {
    public static void main (String[]args){
        int []array = new int [5];
        for (int i=0; i<array.length; ++i) {
            array [i] = (int) (Math.random()*10);
            System.out.print (" "+array [i]);
        }
        System.out.println (" ");
        for (int i=0; i<1; ++i) {
            int b = array[4];
            System.out.print(" "+b);
        }
        for (int i=0; i<array.length-1; ++i) {
            System.out.print(" "+array [i]);

        }
    }
}

