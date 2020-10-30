package com.example.pharmwebspring.Model;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;

@Getter
@Setter
public class Product {
    private String prod_name;
    private String code;
    private String img_url;
    private int price;
    private String prod_info;
    private int count_p;

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

    public String get_prod_info(){ return prod_info; }
    public void set_prod_info(String prod_info){ this.prod_info = prod_info;  }
}
