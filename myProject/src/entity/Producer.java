package entity;

/**
 * Created by icons on 9.4.17.
 */
public class Producer {

    private long id;
    private String name;
    private String lastname;
    private int yearOfBirth;

    public Producer(long id, String name, String lastname, int yearOfBirth) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.yearOfBirth = yearOfBirth;
    }

    public Producer(String name) {
        this.name = name;

    }

    public Producer(long id) {
        this.id = id;

    }

    public Producer(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    public Producer(long id, String name, String lastname) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
    }

    public Producer(String name, String lastname, int yearOfBirth) {
        this.name = name;
        this.lastname = lastname;
        this.yearOfBirth = yearOfBirth;
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

    public void setName(String name) {
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
        return "Producer{" +
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

        Producer producer = (Producer) o;

        if (id != producer.id) return false;
        if (yearOfBirth != producer.yearOfBirth) return false;
        if (name != null ? !name.equals(producer.name) : producer.name != null) return false;
        return lastname != null ? lastname.equals(producer.lastname) : producer.lastname == null;
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