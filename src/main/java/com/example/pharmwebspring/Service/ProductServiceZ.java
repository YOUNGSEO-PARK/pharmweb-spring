package com.example.pharmwebspring.Service;

import com.example.pharmwebspring.Model.ProductB;
import com.example.pharmwebspring.Model.ProductZ;

import java.util.List;

public interface ProductServiceZ {
    List<ProductZ> listProductZ();

    ProductZ productZ(String prodZ_name);
}
