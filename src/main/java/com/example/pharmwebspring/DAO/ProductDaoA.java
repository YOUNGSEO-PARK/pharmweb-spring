package com.example.pharmwebspring.DAO;

import com.example.pharmwebspring.Model.ProductA;
import com.example.pharmwebspring.Model.ProductB;

import java.util.List;

public interface ProductDaoA {
    List<ProductA> listProductA();
    ProductA detailProductA(String prodA_name);
}
