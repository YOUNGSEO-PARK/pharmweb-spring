package com.example.pharmwebspring.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductF {
    private String prodF_name;
    private String prodF_attribute;
    private String code;
    private String prodF_info_when;
    private String prodF_info_after;
    private String prodF_info_how;
    private String prodF_info_what;
    private String imgF_url;
    private int priceF;
    private int countF_p;

    public String getProdF_name() {
        return prodF_name;
    }

    public void setProdF_name(String prodF_name) {
        this.prodF_name = prodF_name;
    }

    public String getProdF_attribute() {
        return prodF_attribute;
    }

    public void setProdF_attribute(String prodF_attribute) {
        this.prodF_attribute = prodF_attribute;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getProdF_info_when() {
        return prodF_info_when;
    }

    public void setProdF_info_when(String prodF_info_when) {
        this.prodF_info_when = prodF_info_when;
    }

    public String getProdF_info_after() {
        return prodF_info_after;
    }

    public void setProdF_info_after(String prodF_info_after) {
        this.prodF_info_after = prodF_info_after;
    }

    public String getProdF_info_how() {
        return prodF_info_how;
    }

    public void setProdF_info_how(String prodF_info_how) {
        this.prodF_info_how = prodF_info_how;
    }

    public String getProdF_info_what() {
        return prodF_info_what;
    }

    public void setProdF_info_what(String prodF_info_what) {
        this.prodF_info_what = prodF_info_what;
    }

    public String getImgF_url() {
        return imgF_url;
    }

    public void setImgF_url(String imgF_url) {
        this.imgF_url = imgF_url;
    }

    public int getPriceF() {
        return priceF;
    }

    public void setPriceF(int priceF) {
        this.priceF = priceF;
    }

    public int getCountF_p() {
        return countF_p;
    }

    public void setCountF_p(int countF_p) {
        this.countF_p = countF_p;
    }
}
