package be.thomasmore.portal.models;

import javax.persistence.*;

@Entity
public class ContactMessage {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contactmessage_generator")
    @SequenceGenerator(name = "contactmessage_generator", sequenceName = "contactmessage_seq", allocationSize = 1)
    @Id
    private int id;
    private String name;
    private String email;
    private String subject;
    @Column(length = 2500)
    private String message;

    public ContactMessage() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
