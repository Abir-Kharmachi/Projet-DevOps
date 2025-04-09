package com.tphedi.tp.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EtalabAddressResponse {

    public String type;
    public String version;
    public List<com.tphedi.tp.model.Feature> features = new ArrayList<>();
    public String attribution;
    public String licence;
    public String query;
    public int limit = 1;


    @Override
    public String toString() {
        return "EtalabAPIAddress{" +
                "feature{s=" + features +
                ", query='" + query + '\'' +
                '}';
    }


    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Feature {
        private Properties properties;

        public Properties getProperties() {
            return properties;
        }

        public void setProperties(Properties properties) {
            this.properties = properties;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Properties {
        private String label;

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }
    }
}

