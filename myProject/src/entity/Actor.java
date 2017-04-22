package entity;

/**
 * Created by icons on 9.4.17.
 */
public class Actor {

    private long id;
    private String name;
    private String lastname;
    private int yearOfBirth;

    public Actor(long id, String name, String lastname, int yearOfBirth) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.yearOfBirth = yearOfBirth;
    }

    public Actor(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Actor(String name, int yearOfBirth) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
    }

    public Actor(String name) {
        this.name = name;

    }

    public Actor(long id) {
        this.id = id;

    }

    public Actor(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    public Actor(String name, String lastname, int yearOfBirth) {
        this.name = name;
        this.lastname = lastname;
        this.yearOfBirth = yearOfBirth;
    }

    public Actor(long id, String name, String lastname) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String nameLastname) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
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
        if (name != null ? !name.equals(actor.name) : actor.name != null) return false;
        return lastname != null ? lastname.equals(actor.lastname) : actor.lastname == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + yearOfBirth;
        return result;
    }
}
