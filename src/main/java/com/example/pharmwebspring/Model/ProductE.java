package com.example.pharmwebspring.Model;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;

@Getter
@Setter
public class ProductE {
    private String prodE_name;
    private String prodE_attribute;
    private String codeE;
    private String prodE_info_when;
    private String prodE_info_after;
    private String prodE_info_how;
    private String prodE_info_what;
    private String imgE_url;
    private int priceE;
    private int countE_p;

    public String getProdE_name() {
        return prodE_name;
    }

    public void setProdE_name(String prodE_name) {
        this.prodE_name = prodE_name;
    }

    public String getProdE_attribute() {
        return prodE_attribute;
    }

    public void setProdE_attribute(String prodE_attribute) {
        this.prodE_attribute = prodE_attribute;
    }

    public String getCodeE() {
        return codeE;
    }

    public void setCodeE(String codeE) {
        this.codeE = codeE;
    }

    public String getProdE_info_when() {
        return prodE_info_when;
    }

    public void setProdE_info_when(String prodE_info_when) {
        this.prodE_info_when = prodE_info_when;
    }

    public String getProdE_info_after() {
        return prodE_info_after;
    }

    public void setProdE_info_after(String prodE_info_after) {
        this.prodE_info_after = prodE_info_after;
    }

    public String getProdE_info_how() {
        return prodE_info_how;
    }

    public void setProdE_info_how(String prodE_info_how) {
        this.prodE_info_how = prodE_info_how;
    }

    public String getProdE_info_what() {
        return prodE_info_what;
    }

    public void setProdE_info_what(String prodE_info_what) {
        this.prodE_info_what = prodE_info_what;
    }

    public String getImgE_url() {
        return imgE_url;
    }

    public void setImgE_url(String imgE_url) {
        this.imgE_url = imgE_url;
    }

    public int getPriceE() {
        return priceE;
    }

    public void setPriceE(int priceE) {
        this.priceE = priceE;
    }

    public int getCountE_p() {
        return countE_p;
    }

    public void setCountE_p(int countE_p) {
        this.countE_p = countE_p;
    }
}
