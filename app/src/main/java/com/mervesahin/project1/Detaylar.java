package com.mervesahin.project1;

public class Detaylar {
    private int detay_id;
    private String detay_adi;
    private String detay_bilgi;
    private String detay_resim;


    public Detaylar() {
    }

    public Detaylar(int detay_id, String detay_adi, String detay_bilgi, String detay_resim) {
        this.detay_id = detay_id;
        this.detay_adi = detay_adi;
        this.detay_bilgi=detay_bilgi;
        this.detay_resim = detay_resim;
    }

    public Detaylar(int detay_id, String detay_adi, String detay_bilgi, String detay_resim, City s) {
    }

    public int getDetay_id() {
        return detay_id;
    }

    public void setDetay_id(int detay_id) {
        this.detay_id = detay_id;
    }

    public String getDetay_adi() {
        return detay_adi;
    }

    public void setDetay_adi(String detay_adi) {
        this.detay_adi = detay_adi;
    }

    public String getDetay_bilgi() {
        return detay_bilgi;
    }

    public void setDetay_bilgi(String detay_bilgi) {
        this.detay_bilgi = detay_bilgi;
    }

    public String getDetay_resim() {
        return detay_resim;
    }

    public void setDetay_resim(String detay_resim) {
        this.detay_resim = detay_resim;
    }
}
