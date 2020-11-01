package com.example.pharmwebspring.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductB {
    private String prodB_name;
    private String prodB_attribute;
    private String code;
    private String prodB_info_when;
    private String prodB_info_after;
    private String prodB_info_how;
    private String prodB_info_what;
    private String imgB_url;
    private int priceB;
    private int countB_p;

    public String getProdB_name() {
        return prodB_name;
    }

    public void setProdB_name(String prodB_name) {
        this.prodB_name = prodB_name;
    }

    public String getProdB_attribute() {
        return prodB_attribute;
    }

    public void setProdB_attribute(String prodB_attribute) {
        this.prodB_attribute = prodB_attribute;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getProdB_info_when() {
        return prodB_info_when;
    }

    public void setProdB_info_when(String prodB_info_when) {
        this.prodB_info_when = prodB_info_when;
    }

    public String getProdB_info_after() {
        return prodB_info_after;
    }

    public void setProdB_info_after(String prodB_info_after) {
        this.prodB_info_after = prodB_info_after;
    }

    public String getProdB_info_how() {
        return prodB_info_how;
    }

    public void setProdB_info_how(String prodB_info_how) {
        this.prodB_info_how = prodB_info_how;
    }

    public String getProdB_info_what() {
        return prodB_info_what;
    }

    public void setProdB_info_what(String prodB_info_what) {
        this.prodB_info_what = prodB_info_what;
    }

    public String getImgB_url() {
        return imgB_url;
    }

    public void setImgB_url(String imgB_url) {
        this.imgB_url = imgB_url;
    }

    public int getPriceB() {
        return priceB;
    }

    public void setPriceB(int priceB) {
        this.priceB = priceB;
    }

    public int getCountB_p() {
        return countB_p;
    }

    public void setCountB_p(int countB_p) {
        this.countB_p = countB_p;
    }
}
