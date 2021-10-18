package com.amazetrip.app.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="trip_id")
    private int id = 0;

    @OneToMany(mappedBy = "trip", fetch=FetchType.EAGER)
    private Set<Comment> comments;

    @ManyToMany()
    private Set<Place> places;

    private Date creationDate;

    public int getId() {
        return id;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public Set<Place> getPlaces() {
        return places;
    }

    public void setPlaces(Set<Place> places) {
        this.places = places;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
