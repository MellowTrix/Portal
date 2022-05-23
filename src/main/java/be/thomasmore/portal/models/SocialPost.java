package be.thomasmore.portal.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class SocialPost {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "social_generator")
    @SequenceGenerator(name = "social_generator", sequenceName = "social_seq", allocationSize = 1)
    @Id
    private int id;
    @ManyToOne
    private User owner;
    private String subject;
    @Column(length = 1500)
    private String message;
    private LocalDate creationDate;

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public SocialPost() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
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
