package com.example.pharmwebspring.Service;

import com.example.pharmwebspring.Model.Product;
import com.example.pharmwebspring.Model.ProductB;

import java.util.List;

public interface ProductServiceB {
    List<ProductB> listProductB();
    ProductB productB(String prodB_name);
}
