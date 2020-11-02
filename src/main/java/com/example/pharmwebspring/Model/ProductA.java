package com.example.pharmwebspring.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductA {
    private String prodA_name;
    private String prodA_attribute;
    private String code;
    private String prodA_info_when;
    private String prodA_info_after;
    private String prodA_info_how;
    private String prodA_info_what;
    private String imgA_url;
    private int priceA;
    private int countA_p;

    public String getProdA_name() {
        return prodA_name;
    }

    public void setProdA_name(String prodA_name) {
        this.prodA_name = prodA_name;
    }

    public String getProdA_attribute() {
        return prodA_attribute;
    }

    public void setProdA_attribute(String prodA_attribute) {
        this.prodA_attribute = prodA_attribute;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getProdA_info_when() {
        return prodA_info_when;
    }

    public void setProdA_info_when(String prodA_info_when) {
        this.prodA_info_when = prodA_info_when;
    }

    public String getProdA_info_after() {
        return prodA_info_after;
    }

    public void setProdA_info_after(String prodA_info_after) {
        this.prodA_info_after = prodA_info_after;
    }

    public String getProdA_info_how() {
        return prodA_info_how;
    }

    public void setProdA_info_how(String prodA_info_how) {
        this.prodA_info_how = prodA_info_how;
    }

    public String getProdA_info_what() {
        return prodA_info_what;
    }

    public void setProdA_info_what(String prodA_info_what) {
        this.prodA_info_what = prodA_info_what;
    }

    public String getImgA_url() {
        return imgA_url;
    }

    public void setImgA_url(String imgA_url) {
        this.imgA_url = imgA_url;
    }

    public int getPriceA() {
        return priceA;
    }

    public void setPriceA(int priceA) {
        this.priceA = priceA;
    }

    public int getCountA_p() {
        return countA_p;
    }

    public void setCountA_p(int countA_p) {
        this.countA_p = countA_p;
    }
}
