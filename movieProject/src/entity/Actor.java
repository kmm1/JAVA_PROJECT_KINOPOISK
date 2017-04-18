package entity;

/**
 * Created by icons on 9.4.17.
 */
public class Actor {

    private long id;
    private String nameLastname;
    private int yearOfBirth;

    public Actor(long id, String nameLastname, int yearOfBirth) {
        this.id = id;
        this.nameLastname = nameLastname;
        this.yearOfBirth = yearOfBirth;
    }

    public Actor(long id, String nameLastname) {
        this.id = id;
        this.nameLastname = nameLastname;
    }

    public Actor( String nameLastname, int yearOfBirth) {
        this.nameLastname = nameLastname;
        this.yearOfBirth = yearOfBirth;
    }

    public Actor( String nameLastname) {
        this.nameLastname = nameLastname;

    }

    public Actor(long id) {
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

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", nameLastname='" + nameLastname + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Actor actor = (Actor) o;

        if (id != actor.id) return false;
        if (yearOfBirth != actor.yearOfBirth) return false;
        return nameLastname != null ? nameLastname.equals(actor.nameLastname) : actor.nameLastname == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (nameLastname != null ? nameLastname.hashCode() : 0);
        result = 31 * result + yearOfBirth;
        return result;
    }
}
