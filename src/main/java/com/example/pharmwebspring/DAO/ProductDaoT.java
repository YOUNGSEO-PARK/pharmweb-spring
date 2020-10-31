package com.example.pharmwebspring.DAO;

import com.example.pharmwebspring.Model.Product;
import com.example.pharmwebspring.Model.ProductT;

import java.util.List;

public interface ProductDaoT {
    List<ProductT> listProductT();
    ProductT detailProductT(String prodT_name);
}
