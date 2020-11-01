package com.example.pharmwebspring.Model;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;

@Getter
@Setter
public class ProductT {
    private String prodT_name;
    private String prodT_attribute;
    private String codeT;
    private String prodT_info_when;
    private String prodT_info_after;
    private String prodT_info_how;
    private String prodT_info_what;
    private String imgT_url;
    private int priceT;
    private int countT_p;

    public String getProdT_name() {
        return prodT_name;
    }

    public void setProdT_name(String prodT_name) {
        this.prodT_name = prodT_name;
    }

    public String getProdT_attribute() {
        return prodT_attribute;
    }

    public void setProdT_attribute(String prodT_attribute) {
        this.prodT_attribute = prodT_attribute;
    }

    public String getCodeT() {
        return codeT;
    }

    public void setCodeT(String codeT) {
        this.codeT = codeT;
    }

    public String getProdT_info_when() {
        return prodT_info_when;
    }

    public void setProdT_info_when(String prodT_info_when) {
        this.prodT_info_when = prodT_info_when;
    }

    public String getProdT_info_after() {
        return prodT_info_after;
    }

    public void setProdT_info_after(String prodT_info_after) {
        this.prodT_info_after = prodT_info_after;
    }

    public String getProdT_info_how() {
        return prodT_info_how;
    }

    public void setProdT_info_how(String prodT_info_how) {
        this.prodT_info_how = prodT_info_how;
    }

    public String getProdT_info_what() {
        return prodT_info_what;
    }

    public void setProdT_info_what(String prodT_info_what) {
        this.prodT_info_what = prodT_info_what;
    }

    public String getImgT_url() {
        return imgT_url;
    }

    public void setImgT_url(String imgT_url) {
        this.imgT_url = imgT_url;
    }

    public int getPriceT() {
        return priceT;
    }

    public void setPriceT(int priceT) {
        this.priceT = priceT;
    }

    public int getCountT_p() {
        return countT_p;
    }

    public void setCountT_p(int countT_p) {
        this.countT_p = countT_p;
    }
}
