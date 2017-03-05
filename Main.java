package collections.students;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


/**
 * Created by icons on 4.3.17.
 */
public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Анна", "Будай", 22, 10));
        students.add(new Student("Галина", "Петрова", 21, 5));
        students.add(new Student("Владимир", "Гавриленок", 20, 7));

        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            System.out.println();


            Collections.sort(students, new ByAgeComparator());
            for (Student student : students) {
                System.out.println(student.getName());
            }
            Collections.sort(students, new ByMarkComparator());
            for (Student student : students) {
                System.out.println(student.getName());
            }
            Collections.sort(students, new ByNameComparator());
            for (Student student : students) {
                System.out.println(student.getName() + " " + student.getLastname());
            }
        }
    }
}
