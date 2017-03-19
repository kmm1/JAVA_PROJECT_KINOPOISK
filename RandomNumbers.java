import java.io.*;
import java.util.*;

/**
 * Created by icons on 16.3.17.
 */
public class RandomNumbers {
    public static void main(String[] args) {

        int arr[] = new int[20];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 10);
        }
        int arr2[] = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arr2);
        try (PrintWriter writer = new PrintWriter(new File("Num.txt"))) {
            writer.write(Arrays.toString(arr) + "\n");
            writer.write(Arrays.toString(arr2));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}