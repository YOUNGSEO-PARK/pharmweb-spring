package com.example.pharmwebspring.Model;

public class Order {
    private String order_no;
    private String order_name;
    private String order_phone;
    private String order_adr1;
    private String order_adr2;
    private String order_msg;
    private String order_prod;
    private String order_user_id;
    private String order_status;

    public String getOrder_no() {

        return order_no;
    }

    public void setOrder_no(String order_no) {

        this.order_no = order_no;
    }

    public String getOrder_name() {

        return order_name;
    }

    public void setOrder_name(String order_name) {

        this.order_name = order_name;
    }

    public String getOrder_phone() {

        return order_phone;
    }

    public void setOrder_phone(String order_phone) {

        this.order_phone = order_phone;
    }

    public String getOrder_adr1() {
        return order_adr1;
    }

    public void setOrder_adr1(String order_adr1) {

        this.order_adr1 = order_adr1;
    }

    public String getOrder_adr2() {

        return order_adr2;
    }

    public void setOrder_adr2(String order_adr2) {

        this.order_adr2 = order_adr2;
    }

    public String getOrder_msg() {

        return order_msg;
    }

    public void setOrder_msg(String order_msg) {

        this.order_msg = order_msg;
    }

    public String getOrder_prod() {

        return order_prod;
    }

    public void setOrder_prod(String order_prod) {

        this.order_prod = order_prod;
    }

    public String getOrder_user_id() {

        return order_user_id;
    }

    public String getOrder_status() {

        return order_status;
    }

    public void setOrder_status(String order_status) {

        this.order_status = order_status;
    }

    public void setOrder_user_id(String order_user_id) {

        this.order_user_id = order_user_id;
    }
}