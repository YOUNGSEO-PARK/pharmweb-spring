package com.example.pharmwebspring.Service;

import com.example.pharmwebspring.Model.ProductB;
import com.example.pharmwebspring.Model.ProductN;

import java.util.List;

public interface ProductServiceN {
    List<ProductN> listProductN();
    ProductN productN(String prodN_name);
}
