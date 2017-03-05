package collections.students;

/**
 * Created by icons on 4.3.17.
 */

    public class Student {
    String name;
    String lastname;
    int age;
    double mark;

    public Student(String name, String lastname, int age, double mark) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public int getAge() {
        return age;
    }

    public double getMark() {
        return mark;
    }

}