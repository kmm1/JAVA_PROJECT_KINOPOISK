package collections.students;

import java.util.Comparator;

/**
 * Created by icons on 4.3.17.
 */

    public class ByMarkComparator implements Comparator<Student> {
        @Override
        public int compare(Student firstStudent, Student secondStudent) {
            return new Double (firstStudent.getMark()).compareTo(secondStudent.getMark());
        }
    }