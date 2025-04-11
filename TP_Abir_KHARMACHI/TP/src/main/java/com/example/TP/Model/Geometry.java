package com.example.TP.Model;

import java.util.ArrayList;

public class Geometry {
    private String type;
    private ArrayList< Float > coordinates = new ArrayList < Float > ();


    // Getter Methods

    public String getType() {
        return type;
    }

    // Setter Methods

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<Float> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(ArrayList<Float> coordinates) {
        this.coordinates = coordinates;
    }
}
