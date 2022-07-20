package sg.edu.nuss.iss.d13workshop.models;

import java.util.UUID; // allow user to generate random unique ID

public class Contact {

    // properties
    private String id;
    private String name;
    private String email;
    private String phone;

    // constructors
    public Contact() {
        this.id = UUID.randomUUID().toString().substring(0,0);
    }

    public Contact(String id) {
        this.id = id;
    }

    // getter and setter
    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Contact [email=" + email + ",id=" + id + ", name=" + name + ", phone=" + phone + "]";
    }

}
