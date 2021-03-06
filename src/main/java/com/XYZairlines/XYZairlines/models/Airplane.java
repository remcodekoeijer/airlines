package com.XYZairlines.XYZairlines.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Airplane {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private static final int maxFuel = 5000;
    private int currentFuel;
    private Location currentLocation;



    public Airplane(){}

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

//    public int getMaxFuel() {
//        return maxFuel;
//    }
//    public void setMaxFuel(int maxFuel) {
//        this.maxFuel = maxFuel;
//    }

    public int getCurrentFuel() {
        return currentFuel;
    }
    public void setCurrentFuel(int currentFuel) {
        this.currentFuel = currentFuel;
        if(currentFuel > maxFuel)
            this.currentFuel = maxFuel;
    }
    public void setToMaxFuel(){
        currentFuel = maxFuel;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }
    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }
}
