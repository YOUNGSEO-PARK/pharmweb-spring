package com.example.pharmwebspring.Service;

import java.util.List;
import com.example.pharmwebspring.Model.Product;
import com.example.pharmwebspring.Model.ProductB;

public interface ProductService {
    List<Product> listProduct();
    Product product(String prod_name);
}
