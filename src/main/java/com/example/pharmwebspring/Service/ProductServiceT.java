package com.example.pharmwebspring.Service;

import com.example.pharmwebspring.Model.ProductB;
import com.example.pharmwebspring.Model.ProductT;

import java.util.List;

public interface ProductServiceT {
    List<ProductT> listProductT();
    ProductT productT(String prodT_name);
}
