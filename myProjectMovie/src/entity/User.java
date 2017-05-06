package entity;

/**
 * Created by icons on 9.4.17.
 */
public class User {

    private long id;
    private String name;
    private String lastname;
    private String email;
    private String password;
    private String role;

    public User(long id, String name, String lastname, String email, String password, String role) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User(String name, String lastname, String email, String password) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }


    public User(long id) {
        this.id = id;
    }

    public User(String name) {
        this.name = name;
    }

    public User(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public User(String name, String lastname, String email, String pastword, String role) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.password = pastword;
        this.role = role;
    }

    public User(long id, String name, String lastname, String role) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.role = role;
    }

    public User(long id, String name, String lastname) {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String pastword) {
        this.password = pastword;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", pastword='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
