package be.thomasmore.portal.models;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
public class User {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
    @SequenceGenerator(name = "user_generator", sequenceName = "user_sequence", allocationSize = 1)
    @Id
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String role;
    private int monthsSubscribed;
    private Boolean freeTrialAvailable;
    @DateTimeFormat(pattern = "yyyy-MM-dd-HH.mm.ss")
    private Date subscriptionEndDate;

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getMonthsSubscribed() {
        return monthsSubscribed;
    }

    public void setMonthsSubscribed(Integer monthsSubscribed) {
        this.monthsSubscribed = monthsSubscribed;
    }

    public void setMonthsSubscribed(int monthsSubscribed) {
        this.monthsSubscribed = monthsSubscribed;
    }

    public Boolean getFreeTrialAvailable() {
        return freeTrialAvailable;
    }

    public void setFreeTrialAvailable(Boolean freeTrialAvailable) {
        this.freeTrialAvailable = freeTrialAvailable;
    }

    public Date getSubscriptionEndDate() {
        return subscriptionEndDate;
    }

    public void setSubscriptionEndDate(Date subscriptionEndDate) {
        this.subscriptionEndDate = subscriptionEndDate;
    }
}
