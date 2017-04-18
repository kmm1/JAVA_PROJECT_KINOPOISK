package entity;

/**
 * Created by icons on 9.4.17.
 */
public class Producer {

    private long id;
    private String nameLastname;
    private int yearOfBirth;

    public Producer(long id, String nameLastname, int yearOfBirth) {
        this.id = id;
        this.nameLastname = nameLastname;
        this.yearOfBirth = yearOfBirth;
    }

    public Producer(String nameLastname) {
        this.nameLastname = nameLastname;

    }

    public Producer(long id) {
        this.id = id;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameLastname() {
        return nameLastname;
    }

    public void setNameLastname(String nameLastname) {
        this.nameLastname = nameLastname;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }


}