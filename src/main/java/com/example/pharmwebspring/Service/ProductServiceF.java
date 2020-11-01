package com.example.pharmwebspring.Service;

import com.example.pharmwebspring.Model.ProductB;
import com.example.pharmwebspring.Model.ProductF;

import java.util.List;

public interface ProductServiceF {
    List<ProductF> listProductF();
    ProductF productF(String prodF_name);
}
