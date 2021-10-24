package com.amazetrip.api.model;


import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="trip_id")
    private int id = 0;

    @OneToMany(mappedBy = "trip", fetch=FetchType.LAZY)
    private List<Comment> comments;

    @ManyToMany( fetch=FetchType.LAZY)
    private List<Place> places;

    private Date creationDate;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;



    public int getId() {
        return id;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String toString() { return "Trajet n°" + this.id +" créé le "+this.creationDate+" de "+this.getPlaces().get(0).getName()+" à "+this.getPlaces().get(this.getPlaces().size()-1).getName(); }
}
