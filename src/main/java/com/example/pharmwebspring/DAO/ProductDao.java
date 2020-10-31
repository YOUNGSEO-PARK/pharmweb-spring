package com.example.pharmwebspring.DAO;

import com.example.pharmwebspring.Model.Product;

import java.util.List;

public interface ProductDao {
    List<Product> listProduct();
    Product detailProduct(String prod_name);
}
