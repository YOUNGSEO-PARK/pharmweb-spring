package com.example.pharmwebspring.DAO;

import com.example.pharmwebspring.Model.Product;
import com.example.pharmwebspring.Model.ProductH;

import java.util.List;

public interface ProductDaoH {
    List<ProductH> listProductH();
    ProductH detailProductH(String prodH_name);
}
