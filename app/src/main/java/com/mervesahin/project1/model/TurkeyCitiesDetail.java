package com.mervesahin.project1.model;

public class TurkeyCitiesDetail {
    private String details_id;
    private String details_name;
    private String details_detail;
    private String details_image;


    public TurkeyCitiesDetail() {

    }

    public TurkeyCitiesDetail(String details_id, String details_name, String details_detail, String details_image) {
        this.details_id = details_id;
        this.details_name = details_name;
        this.details_detail=details_detail;
        this.details_image = details_image;
    }

    public TurkeyCitiesDetail(String details_id, String details_name, String details_detail, String details_image, TurkeyCity s) {
    }

    public String getDetails_id() {
        return details_id;
    }

    public void setDetails_id(String details_id) {
        this.details_id = details_id;
    }

    public  String getDetails_name() {
        return details_name;
    }

    public void setDetails_name(String details_name) {
        this.details_name = details_name;
    }

    public  String getDetails_detail() {
        return details_detail;
    }

    public void setDetails_detail(String details_detail) {
        this.details_detail = details_detail;
    }

    public String getDetails_image() {
        return details_image;
    }

    public void setDetails_image(String details_image) {
        this.details_image = details_image;
    }
}
