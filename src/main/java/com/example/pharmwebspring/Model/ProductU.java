package com.example.pharmwebspring.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductU {
    private String prodU_name;
    private String prodU_attribute;
    private String code;
    private String prodU_info_when;
    private String prodU_info_after;
    private String prodU_info_how;
    private String prodU_info_what;
    private String imgU_url;
    private int priceU;
    private int countU_p;

    public String getProdU_name() {
        return prodU_name;
    }

    public void setProdU_name(String prodU_name) {
        this.prodU_name = prodU_name;
    }

    public String getProdU_attribute() {
        return prodU_attribute;
    }

    public void setProdU_attribute(String prodU_attribute) {
        this.prodU_attribute = prodU_attribute;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getProdU_info_when() {
        return prodU_info_when;
    }

    public void setProdU_info_when(String prodU_info_when) {
        this.prodU_info_when = prodU_info_when;
    }

    public String getProdU_info_after() {
        return prodU_info_after;
    }

    public void setProdU_info_after(String prodU_info_after) {
        this.prodU_info_after = prodU_info_after;
    }

    public String getProdU_info_how() {
        return prodU_info_how;
    }

    public void setProdU_info_how(String prodU_info_how) {
        this.prodU_info_how = prodU_info_how;
    }

    public String getProdU_info_what() {
        return prodU_info_what;
    }

    public void setProdU_info_what(String prodU_info_what) {
        this.prodU_info_what = prodU_info_what;
    }

    public String getImgU_url() {
        return imgU_url;
    }

    public void setImgU_url(String imgU_url) {
        this.imgU_url = imgU_url;
    }

    public int getPriceU() {
        return priceU;
    }

    public void setPriceU(int priceU) {
        this.priceU = priceU;
    }

    public int getCountU_p() {
        return countU_p;
    }

    public void setCountU_p(int countU_p) {
        this.countU_p = countU_p;
    }
}
