package com.example.pharmwebspring.Service;

import com.example.pharmwebspring.Model.ProductA;
import com.example.pharmwebspring.Model.ProductB;

import java.util.List;

public interface ProductServiceA {
    List<ProductA> listProductA();
    ProductA productA(String prodA_name);
}
