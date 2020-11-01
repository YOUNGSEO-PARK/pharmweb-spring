package com.example.pharmwebspring.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cart {

    private int cart_no;        //주문번호(하나씩 올라감)
    private String user_id;
    private String cart_prod_name;   //상품이름
    private int cart_prod_price;          //상품 한개 가격
    private int count_p;        //상품개수
    private int count_s;        //상품종류 개수
    private String cart_img_url;     //상품 이미지
    private int summoney;  //같은 상품 가격 총액
    private int carttotal;  //장바구니 전체 총액
    private String code;

    public int getCart_no() {
        return cart_no;
    }

    public void setCart_no(int cart_no) {
        this.cart_no = cart_no;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }


    public int getCount_p() {
        return count_p;
    }

    public void setCount_p(int count_p) {
        this.count_p = count_p;
    }

    public String getCart_prod_name() {
        return cart_prod_name;
    }

    public void setCart_prod_name(String cart_prod_name) {
        this.cart_prod_name = cart_prod_name;
    }

    public int getCart_prod_price() {
        return cart_prod_price;
    }

    public void setCart_prod_price(int cart_prod_price) {
        this.cart_prod_price = cart_prod_price;
    }

    public String getCart_img_url() {
        return cart_img_url;
    }

    public void setCart_img_url(String cart_img_url) {
        this.cart_img_url = cart_img_url;
    }

    public int getSummoney() {
        summoney = cart_prod_price * count_p;
        return summoney;
    }

    public void setSummoney(int summoney) {
        this.summoney = summoney;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void addSummony(int summoney) {
        this.summoney += summoney;
    }

    public void addCount(int count) {
        this.count_p += count;
    }
}
