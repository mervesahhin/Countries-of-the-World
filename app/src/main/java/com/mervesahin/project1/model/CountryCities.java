package com.mervesahin.project1.model;

public class CountryCities {
    private String countrycities_id;
    private String countrycities_image;
    private String countrycities_name;
    private String countrycities_info;

    public CountryCities() {
    }

    public CountryCities(String countrycities_id, String countrycities_name,  String countrycities_image,String countrycities_info) {
        this.countrycities_id = countrycities_id;
        this.countrycities_name = countrycities_name;
        this.countrycities_image = countrycities_image;
        this.countrycities_info = countrycities_info;
    }

    public String getCountrycities_id() {
        return countrycities_id;
    }

    public void setCountrycities_id(String countrycities_id) {
        this.countrycities_id = countrycities_id;
    }

    public String getCountrycities_image() {
        return countrycities_image;
    }

    public void setCountrycities_image(String countrycities_image) {
        this.countrycities_image = countrycities_image;
    }

    public String getCountrycities_name() {
        return countrycities_name;
    }

    public void setCountrycities_name(String countrycities_name) {
        this.countrycities_name = countrycities_name;
    }

    public String getCountrycities_info() {
        return countrycities_info;
    }

    public void setCountrycities_info(String countrycities_info) {
        this.countrycities_info = countrycities_info;
    }
}
