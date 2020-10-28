package com.example.pharmwebspring.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Order {
    private int order_no;
    private String order_name;
    private String order_adr1;
    private String order_adr2;
    private String order_phone;
    //private String prod_name;
    //private String pharm_name;
    private String order_msg;
}
