package com.mervesahin.project1.model;

public class Continent {
    private String continent_id;
    private String continent_name;
    private String continent_image;

    public Continent() {
    }

    public Continent(String continent_id, String continent_name, String continent_image) {
        this.continent_id = continent_id;
        this.continent_name = continent_name;
        this.continent_image = continent_image;
    }

    public String getContinent_id() {
        return continent_id;
    }

    public void setContinent_id(String continent_id) {
        this.continent_id = continent_id;
    }

    public String getContinent_name() {
        return continent_name;
    }

    public void setContinent_name(String continent_name) {
        this.continent_name = continent_name;
    }

    public String getContinent_image() {
        return continent_image;
    }

    public void setContinent_image(String continent_image) {
        this.continent_image = continent_image;
    }
}
