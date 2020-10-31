package com.example.pharmwebspring.Model;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;

@Getter
@Setter
public class Product {
    private String prod_name;
    private String prod_attribute;
    private String code;
    private String prod_info_when;
    private String prod_info_after;
    private String prod_info_how;
    private String prod_info_what;
    private String img_url;
    private int price;
    private int count_p;

    public String getProd_attribute() {
        return prod_attribute;
    }

    public void setProd_attribute(String prod_attribute) {
        this.prod_attribute = prod_attribute;
    }

    public String getProd_info_when() {
        return prod_info_when;
    }

    public void setProd_info_when(String prod_info_when) {
        this.prod_info_when = prod_info_when;
    }

    public String getProd_info_after() {
        return prod_info_after;
    }

    public void setProd_info_after(String prod_info_after) {
        this.prod_info_after = prod_info_after;
    }

    public String getProd_info_how() {
        return prod_info_how;
    }

    public void setProd_info_how(String prod_info_how) {
        this.prod_info_how = prod_info_how;
    }

    public String getProd_info_what() {
        return prod_info_what;
    }

    public void setProd_info_what(String prod_info_what) {
        this.prod_info_what = prod_info_what;
    }

    public int getCount_p() {
        return count_p;
    }

    public void setCount_p(int count_p) {
        this.count_p = count_p;
    }

    public String get_prod_name() { return prod_name; }
    public void set_prod_name(String prod_name) {
        this.prod_name = prod_name;
    }

    public String get_code() { return code; }
    public void set_code(String code){  this.code = code; }

    public String get_img_url(){ return img_url; }
    public void set_img_url(String img_url){ this.img_url = img_url; }

    public int get_price(){ return price; }
    public void set_price(int price){ this.price = price;  }
}
