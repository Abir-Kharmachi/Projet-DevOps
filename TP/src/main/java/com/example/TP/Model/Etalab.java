package com.example.TP.Model;

import java.util.ArrayList;
import java.util.List;

public class Etalab {
    public String type;
    public String version;
    public List<Feature> features = new ArrayList<>();
    public String attribution;
    public String licence;
    public String query;
    public int limit = 1;

    //toString
    @Override
    public String toString() {
        return "EtalabAPIAddress{" +
                "feature{s=" + features +
                ", query='" + query + '\'' +
                '}';
    }
}
