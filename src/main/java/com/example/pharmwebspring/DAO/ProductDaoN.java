package com.example.pharmwebspring.DAO;

import com.example.pharmwebspring.Model.Product;
import com.example.pharmwebspring.Model.ProductN;

import java.util.List;

public interface ProductDaoN {
    List<ProductN> listProductN();
    ProductN detailProductN(String prodN_name);
}
