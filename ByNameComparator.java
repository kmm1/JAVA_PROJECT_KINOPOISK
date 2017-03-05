package collections.students;
import java.util.Comparator;

/**
 * Created by icons on 4.3.17.
 */
public class ByNameComparator implements Comparator<Student> {

        @Override
        public int compare(Student firstStudent, Student secondStudent) {
            return firstStudent.getName().compareTo(secondStudent.getName());
        }
    }
