package collections.students;

import java.util.Comparator;

/**
 * Created by icons on 4.3.17.
 */
public class ByAgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student firstStudent, Student secondStudent) {
        return new Integer(firstStudent.getAge()).compareTo(secondStudent.getAge());
    }
}
