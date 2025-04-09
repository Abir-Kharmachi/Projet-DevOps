package com.tphedi.tp.model;

import java.util.ArrayList;

public class Geometry {

        private String type;
        private ArrayList< Float > coordinates = new ArrayList < Float > ();


        // Getter Methods

        public String getType() {
            return type;
        }



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

