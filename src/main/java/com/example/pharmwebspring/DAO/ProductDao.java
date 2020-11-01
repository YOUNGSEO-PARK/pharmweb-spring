package com.example.pharmwebspring.DAO;

import com.example.pharmwebspring.Model.Product;

import java.util.List;

public interface ProductDao {
    List<Product> listProduct();
    Product detailProduct(String prod_name);
    //void updateProduct(Product product);
    //void deleteProduct(String prod_name);
    //void insertProduct(Product product);
    //String fileInfo(String prod_name);
}
