package com.example.pharmwebspring.Service;

import com.example.pharmwebspring.Model.ProductB;
import com.example.pharmwebspring.Model.ProductH;

import java.util.List;

public interface ProductServiceH {
    List<ProductH> listProductH();
    ProductH productH(String prodH_name);
}
