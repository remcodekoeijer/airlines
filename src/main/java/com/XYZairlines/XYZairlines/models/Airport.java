package com.XYZairlines.XYZairlines.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Location location;

    @OneToMany
    private List<Airplane> airplanes;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public Location getLocation() {
        return location;
    }
    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Airplane> getAirplanes() {
        return airplanes;
    }
    public void setAirplanes(List<Airplane> airplanes) {
        this.airplanes = airplanes;
    }
}
