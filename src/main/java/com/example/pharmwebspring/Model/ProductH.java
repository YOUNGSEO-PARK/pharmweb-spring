package com.example.pharmwebspring.Model;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;

@Getter
@Setter
public class ProductH {
    private String prodH_name;
    private String prodH_attribute;
    private String codeH;
    private String prodH_info_when;
    private String prodH_info_after;
    private String prodH_info_how;
    private String prodH_info_what;
    private String imgH_url;
    private int priceH;
    private int countH_p;

    public String getProdH_name() {
        return prodH_name;
    }

    public void setProdH_name(String prodH_name) {
        this.prodH_name = prodH_name;
    }

    public String getProdH_attribute() {
        return prodH_attribute;
    }

    public void setProdH_attribute(String prodH_attribute) {
        this.prodH_attribute = prodH_attribute;
    }

    public String getCodeH() {
        return codeH;
    }

    public void setCodeH(String codeH) {
        this.codeH = codeH;
    }

    public String getProdH_info_when() {
        return prodH_info_when;
    }

    public void setProdH_info_when(String prodH_info_when) {
        this.prodH_info_when = prodH_info_when;
    }

    public String getProdH_info_after() {
        return prodH_info_after;
    }

    public void setProdH_info_after(String prodH_info_after) {
        this.prodH_info_after = prodH_info_after;
    }

    public String getProdH_info_how() {
        return prodH_info_how;
    }

    public void setProdH_info_how(String prodH_info_how) {
        this.prodH_info_how = prodH_info_how;
    }

    public String getProdH_info_what() {
        return prodH_info_what;
    }

    public void setProdH_info_what(String prodH_info_what) {
        this.prodH_info_what = prodH_info_what;
    }

    public String getImgH_url() {
        return imgH_url;
    }

    public void setImgH_url(String imgH_url) {
        this.imgH_url = imgH_url;
    }

    public int getPriceH() {
        return priceH;
    }

    public void setPriceH(int priceH) {
        this.priceH = priceH;
    }

    public int getCountH_p() {
        return countH_p;
    }

    public void setCountH_p(int countH_p) {
        this.countH_p = countH_p;
    }
}
