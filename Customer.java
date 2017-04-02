/**
 * Created by icons on 2.4.17.
 */
public class Customer {

    private String name;
    private String lastname;
    private String email;
    private String pastword;
    private String phone;
    private String address;


    public Customer(String name, String lastname, String email, String pastword, String phone, String address) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.pastword = pastword;
        this.phone = phone;
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }


    public void setPastword(String pastword) {
        this.pastword = pastword;
    }

    public String getPastword() {
        return pastword;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}

