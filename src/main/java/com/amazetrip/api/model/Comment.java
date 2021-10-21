package com.amazetrip.api.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="comment_id")
    private int id = 0;

    @ManyToOne()
    @JoinColumn(name = "trip_id")
    private Trip trip;

    @ManyToOne()
    @JoinColumn(name = "place_id")
    private Place place;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;

    private Date creationDate;

    public int getId() {
        return id;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
