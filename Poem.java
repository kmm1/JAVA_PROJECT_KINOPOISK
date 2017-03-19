import java.io.*;
import java.util.*;

/**
 * Created by icons on 16.3.17.
 */
public class Poem{
    public static void main(String[] args) {
        File file = new File("Pushkin.txt");
        FileReader fileReader = null;
        List<String> word = new ArrayList<>();
        List<Integer> count = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        try {
            fileReader = new FileReader(file);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String str = scanner.nextLine();
                str = str.toLowerCase();
                str = str.replaceAll("[-.?!)(,:]", "");  //удал все знаки препин
                str = str.replaceAll("\\s+", "");           //удал все прбелы
                String[] words = str.split("");

                for (String x : words) {
                    if (!x.isEmpty()) {
                        Integer num = map.get(x);
                        if (num == null) {
                            num = 0;
                        }
                        map.put(x, ++num);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(map.entrySet());
        FileOutputStream fileOutputStream = null;
        try (PrintWriter writer = new PrintWriter(new File("Pushkin2.txt"))) {
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
      /* решение через 2 ArrayList
                for (String x : words) {
                    if (word.contains(x)) {
                        int index = word.indexOf(x);  //найти в какой ячейке хранится симбол
                        count.set(index, count.get(index) + 1);
                    } else {
                        word.add(x);
                        count.add(1);
                    }
                    for (int i=0;  i<words.size; i++{
                    System.out.println(words.get(i)+"-"+count.get(i));
                    }
                }*/
