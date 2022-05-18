package be.thomasmore.portal.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Post {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_generator")
    @SequenceGenerator(name = "post_generator", sequenceName = "post_sequence", allocationSize = 1)
    @Id
    private Integer id;
    //private User user;
    private String imageUrl;
    private Date date;
    private Integer likes;
}
