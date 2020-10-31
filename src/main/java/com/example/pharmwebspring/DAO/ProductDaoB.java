package com.example.pharmwebspring.DAO;

import com.example.pharmwebspring.Model.Product;
import com.example.pharmwebspring.Model.ProductB;

import java.util.List;

public interface ProductDaoB {
    List<ProductB> listProductB();
    ProductB detailProductB(String prodB_name);
}
