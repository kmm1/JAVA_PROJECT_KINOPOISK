import java.io.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

/**
 * Created by icons on 1.4.17.
 */
public class PatternDemo {

    public static void main(String[] args) throws IOException, ParseException {

        File file = new File("log-file.txt");
        FileReader fileReader = new FileReader(file);
        Scanner scanner = new Scanner(file);
        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<String> list3 = new ArrayList<>();
        List<String> list4 = new ArrayList<>();
        ArrayList<String> list5 = new ArrayList<>();


        for (int i = 0; i < file.length(); i++) {
            while (scanner.hasNextLine()) {
                list.add(scanner.nextLine());
            }
        }

        for (int j = 0; j < list.size(); j++) {
            Pattern pattern = Pattern.compile("(\\d{2}:\\d{2})(\\D+)");
            Matcher matcher = pattern.matcher(list.get(j));
            if (matcher.find()) {
                list2.add(matcher.group(1));
                list3.add(matcher.group(2));
            }
        }

        String string = null;
        try (PrintWriter writer = new PrintWriter(new File("FirstTask.txt"))) {
            for (int i = 0; i < list2.size() - 1; i++) {
                if (list3.get(i).contains("Конец")) {
                    string = " ";
                } else {
                    string = list2.get(i) + "-" + list2.get(i + 1) + list3.get(i);
                }
                writer.write(string + "\n");
                list4.add(string);
            }
        }

        String group1 = null;
        String group2 = null;
        String group4 = null;
        for (int j = 0; j < list4.size(); j++) {
            if (list4.get(j).equals(" ")) {
                list5.add(list4.get(j));
            } else {
                Pattern pattern = Pattern.compile("(\\d{2}:\\d{2})(-)(\\d{2}:\\d{2})(\\D+)");
                Matcher matcher = pattern.matcher(list4.get(j));
                while (matcher.find()) {
                    group1 = (matcher.group(1));
                    group2 = (matcher.group(3));
                    if ((matcher.group(4)).contains("Упражнения")) {
                        group4 = (matcher.group(4));
                    } else if ((matcher.group(4)).contains("Обеденный перерыв")) {
                        group4 = (matcher.group(4));
                    } else if ((matcher.group(4)).contains("Перерыв")) {
                        group4 = (matcher.group(4));
                    } else if ((matcher.group(4)).contains("Решения")) {
                        group4 = (matcher.group(4));
                    } else {
                        group4 = " Лекция";
                    }
                    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                    Date first = sdf.parse(group1);
                    Date second = sdf.parse(group2);
                    long b = ((second.getTime() - first.getTime()) / 60000);
                    list5.add(group4 + ": " + String.valueOf(b) + " минут");
                }
            }
        }
        String string2 = null;
        try (PrintWriter writer = new PrintWriter(new File("SecondTask.txt"))) {
            for (int i = 0; i < list5.size(); i++) {
                string2 = list5.get(i);
                writer.write(string2 + "\n");
            }
        }
    }
}
