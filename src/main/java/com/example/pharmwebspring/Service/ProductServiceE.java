package com.example.pharmwebspring.Service;

import com.example.pharmwebspring.Model.ProductB;
import com.example.pharmwebspring.Model.ProductE;

import java.util.List;

public interface ProductServiceE {
    List<ProductE> listProductE();
    ProductE productE(String prodE_name);
}
