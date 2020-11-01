package com.example.pharmwebspring.DAO;

import com.example.pharmwebspring.Model.Product;
import com.example.pharmwebspring.Model.ProductZ;

import java.util.List;

public interface ProductDaoZ {
    List<ProductZ> listProductZ();
    ProductZ detailProductZ(String prodZ_name);
}
