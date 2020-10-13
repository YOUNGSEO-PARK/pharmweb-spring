package com.example.pharmwebspring.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private String prod_name;
    private int code;
    private String img_uri;
    private int price;
}
