package com.tphedi.tp.model;

import java.util.Map;

public class MeteoConceptResponse {
    private Map<String, String> city;

    private Map<String, String> forecast;

    public MeteoConceptResponse() {
    }

    public MeteoConceptResponse(Map<String, String> city, Map<String, String> forecast) {
        this.city = city;
        this.forecast = forecast;
    }

    public Map<String, String> getCity() {
        return city;
    }

    public void setCity(Map<String, String> city) {
        this.city = city;
    }

    public Map<String, String> getForecast() {
        return forecast;
    }

    public void setForecast(Map<String, String> forecast) {
        this.forecast = forecast;
    }

    @Override
    public String toString() {
        return "MeteoConceptResponse{" +
                "city=" + city +
                ", forecast=" + forecast +
                '}';
    }
}
