package com.amazetrip.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.Set;

@Entity
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="place_id")
    private int id = 0;
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "trip_id")
    private Set<Trip> trips;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Trip> getTrips() {
        return trips;
    }

    public void setTrips(Set<Trip> trips) {
        this.trips = trips;
    }
}
