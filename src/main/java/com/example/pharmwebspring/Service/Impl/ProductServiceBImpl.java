package com.example.pharmwebspring.Service.Impl;

import com.example.pharmwebspring.DAO.ProductDao;
import com.example.pharmwebspring.DAO.ProductDaoB;
import com.example.pharmwebspring.Model.Product;
import com.example.pharmwebspring.Model.ProductB;

import javax.inject.Inject;
import java.util.List;

public class ProductServiceBImpl {
    @Inject
    ProductDaoB productDaoB;

    public List<ProductB> listProductB() {
        return productDaoB.listProductB(); //데이터베이스에 저장된 상품 리스트를 리턴한다.
    }

    public ProductB productB(String prodB_name){
        return productDaoB.detailProductB(prodB_name);
    }
}
