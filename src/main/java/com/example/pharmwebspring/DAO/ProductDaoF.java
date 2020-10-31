package com.example.pharmwebspring.DAO;

import com.example.pharmwebspring.Model.Product;
import com.example.pharmwebspring.Model.ProductF;

import java.util.List;

public interface ProductDaoF {
    List<ProductF> listProductF();
    ProductF detailProductF(String prodF_name);
}
