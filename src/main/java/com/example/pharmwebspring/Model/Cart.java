package com.example.pharmwebspring.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Cart {

    private String user_id;
    private int order_no;
    private String cart_img_uri;
    private String cart_prod_name;
    private int count;
    private int cart_prod_price;

}
