package com.example.pharmwebspring.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductZ {
    private String prodZ_name;
    private String prodZ_attribute;
    private String code;
    private String prodZ_info_when;
    private String prodZ_info_after;
    private String prodZ_info_how;
    private String prodZ_info_what;
    private String imgZ_url;
    private int priceZ;
    private int countZ_p;

    public String getProdZ_name() {
        return prodZ_name;
    }

    public void setProdZ_name(String prodZ_name) {
        this.prodZ_name = prodZ_name;
    }

    public String getProdZ_attribute() {
        return prodZ_attribute;
    }

    public void setProdZ_attribute(String prodZ_attribute) {
        this.prodZ_attribute = prodZ_attribute;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getProdZ_info_when() {
        return prodZ_info_when;
    }

    public void setProdZ_info_when(String prodZ_info_when) {
        this.prodZ_info_when = prodZ_info_when;
    }

    public String getProdZ_info_after() {
        return prodZ_info_after;
    }

    public void setProdZ_info_after(String prodZ_info_after) {
        this.prodZ_info_after = prodZ_info_after;
    }

    public String getProdZ_info_how() {
        return prodZ_info_how;
    }

    public void setProdZ_info_how(String prodZ_info_how) {
        this.prodZ_info_how = prodZ_info_how;
    }

    public String getProdZ_info_what() {
        return prodZ_info_what;
    }

    public void setProdZ_info_what(String prodZ_info_what) {
        this.prodZ_info_what = prodZ_info_what;
    }

    public String getImgZ_url() {
        return imgZ_url;
    }

    public void setImgZ_url(String imgZ_url) {
        this.imgZ_url = imgZ_url;
    }

    public int getPriceZ() {
        return priceZ;
    }

    public void setPriceZ(int priceZ) {
        this.priceZ = priceZ;
    }

    public int getCountZ_p() {
        return countZ_p;
    }

    public void setCountZ_p(int countZ_p) {
        this.countZ_p = countZ_p;
    }
}
