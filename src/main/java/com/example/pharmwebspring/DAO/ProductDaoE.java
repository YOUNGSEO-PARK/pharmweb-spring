package com.example.pharmwebspring.DAO;

import com.example.pharmwebspring.Model.Product;
import com.example.pharmwebspring.Model.ProductE;

import java.util.List;

public interface ProductDaoE {
    List<ProductE> listProductE();
    ProductE detailProductE(String prodE_name);
}
