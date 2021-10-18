package com.amazetrip.app.model;
import javax.persistence.*;

@Entity
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id = 0;

    public int getId() {
        return id;
    }


}
