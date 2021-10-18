package com.amazetrip.app.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="place_id")
    private int id = 0;

    public int getId() {
        return id;
    }

    @ManyToMany()
    @JoinColumn(name = "trip_id")
    private Set<Trip> trips;

    public Set<Trip> getTrips() {
        return trips;
    }

    public void setTrips(Set<Trip> trips) {
        this.trips = trips;
    }
}
