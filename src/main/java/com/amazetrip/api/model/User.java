package com.amazetrip.api.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="user_id")
    private int id = 0;

    private String lastname;

    private String firstname;

    private String email;

    private String password;

    @OneToMany(mappedBy = "user", fetch=FetchType.LAZY)
    private List<Trip> trips;

    @OneToMany(mappedBy = "user", fetch=FetchType.EAGER)
    private Set<Comment> comments;
    
    public User(){
        super();
    }

    public User(String lastname, String firstname, String email, String password){
        super();
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
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

    public void setPassword(String password) {
        this.password = password;
    }
}
