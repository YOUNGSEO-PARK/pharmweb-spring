package com.example.pharmwebspring.Service;

import com.example.pharmwebspring.Model.ProductB;
import com.example.pharmwebspring.Model.ProductU;

import java.util.List;

public interface ProductServiceU {
    List<ProductU> listProductU();
    ProductU productU(String prodU_name);
}
