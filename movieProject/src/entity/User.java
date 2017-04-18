package entity;

/**
 * Created by icons on 9.4.17.
 */
public class User {

    private long id;
    private String name;
    private String lastname;
    private String email;
    private String pastword;

    public User(long id, String name, String lastname, String email, String pastword) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.pastword = pastword;
    }


    public User(long id) {
        this.id = id;
    }

    public User(String name)
    {
        this.name = name;
    }

    public User(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public User(String name, String lastname, String email, String pastword) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.pastword = pastword;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPastword() {
        return pastword;
    }

    public void setPastword(String pastword) {
        this.pastword = pastword;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", pastword='" + pastword + '\'' +
                '}';
    }
}
