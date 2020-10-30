package com.example.pharmwebspring.Service;

import java.util.List;
import com.example.pharmwebspring.Model.Product;
public interface ProductService {
    List<Product> listProduct();
    Product product(String prod_name);
    //String fileInfo(String prod_name);
    //void updateProduct(Product product);
    //void deleteProduct(String prod_name);
    //void insertProduct(Product product);
}
