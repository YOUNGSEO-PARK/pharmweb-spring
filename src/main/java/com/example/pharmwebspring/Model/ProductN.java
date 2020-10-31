package com.example.pharmwebspring.Model;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;

@Getter
@Setter
public class ProductN {
    private String prodN_name;
    private String prodN_attribute;
    private String codeN;
    private String prodN_info_when;
    private String prodN_info_after;
    private String prodN_info_how;
    private String prodN_info_what;
    private String imgN_url;
    private int priceN;
    private int countN_p;

    public String getProdN_name() {
        return prodN_name;
    }

    public void setProdN_name(String prodN_name) {
        this.prodN_name = prodN_name;
    }

    public String getProdN_attribute() {
        return prodN_attribute;
    }

    public void setProdN_attribute(String prodN_attribute) {
        this.prodN_attribute = prodN_attribute;
    }

    public String getCodeN() {
        return codeN;
    }

    public void setCodeN(String codeN) {
        this.codeN = codeN;
    }

    public String getProdN_info_when() {
        return prodN_info_when;
    }

    public void setProdN_info_when(String prodN_info_when) {
        this.prodN_info_when = prodN_info_when;
    }

    public String getProdN_info_after() {
        return prodN_info_after;
    }

    public void setProdN_info_after(String prodN_info_after) {
        this.prodN_info_after = prodN_info_after;
    }

    public String getProdN_info_how() {
        return prodN_info_how;
    }

    public void setProdN_info_how(String prodN_info_how) {
        this.prodN_info_how = prodN_info_how;
    }

    public String getProdN_info_what() {
        return prodN_info_what;
    }

    public void setProdN_info_what(String prodN_info_what) {
        this.prodN_info_what = prodN_info_what;
    }

    public String getImgN_url() {
        return imgN_url;
    }

    public void setImgN_url(String imgN_url) {
        this.imgN_url = imgN_url;
    }

    public int getPriceN() {
        return priceN;
    }

    public void setPriceN(int priceN) {
        this.priceN = priceN;
    }

    public int getCountN_p() {
        return countN_p;
    }

    public void setCountN_p(int countN_p) {
        this.countN_p = countN_p;
    }
}
