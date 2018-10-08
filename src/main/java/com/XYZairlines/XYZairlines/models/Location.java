package com.XYZairlines.XYZairlines.models;

public enum Location {
    AMSTERDAM ("Amsterdam"), LONDON ("London"), PARIS ("Paris"), STOCKHOLM ("Stockholm"), BERLIN ("Berlin");

    private String name;
    Location(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
