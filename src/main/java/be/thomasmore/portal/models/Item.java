package be.thomasmore.portal.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Locale;

@Entity
public class Item {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_generator")
    @SequenceGenerator(name = "item_generator", sequenceName = "item_seq", allocationSize = 1)
    @Id
    private int id;
    private String name;
    @ManyToOne
    private User owner;
    private String color;
    private String itemType;
    private LocalDate creationDate;
    private String link;
    private Boolean deleted;

    public Item() {}

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

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getColor() {
        return color.toLowerCase();
    }

    public void setColor(String color) {
        this.color = color.toLowerCase();
    }

    public String getItemType() {
        return itemType.toLowerCase();
    }

    public void setItemType(String itemType) {
        this.itemType = itemType.toLowerCase();
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
