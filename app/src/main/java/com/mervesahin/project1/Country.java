package com.mervesahin.project1;

public class Country {
    private String country_id;
    private String country_name;
    private String country_image;

    public Country() {
    }

    public Country(String country_id, String country_name, String country_image) {
        this.country_id = country_id;
        this.country_name = country_name;
        this.country_image = country_image;
    }

    public String getCountry_id() {
        return country_id;
    }

    public void setCountry_id(String country_id) {
        this.country_id = country_id;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public String getCountry_image() {
        return country_image;
    }

    public void setCountry_image(String country_image) {
        this.country_image = country_image;
    }
}
