package com.example.pharmwebspring.DAO;

import com.example.pharmwebspring.Model.Product;
import com.example.pharmwebspring.Model.ProductU;

import java.util.List;

public interface ProductDaoU {
    List<ProductU> listProductU();
    ProductU detailProductU(String prodU_name);
}
