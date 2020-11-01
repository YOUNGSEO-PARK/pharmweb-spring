package com.example.pharmwebspring.Service.Impl;

import com.example.pharmwebspring.DAO.ProductDaoB;
import com.example.pharmwebspring.DAO.ProductDaoU;
import com.example.pharmwebspring.Model.ProductB;
import com.example.pharmwebspring.Model.ProductU;

import javax.inject.Inject;
import java.util.List;

public class ProductServiceUImpl {
    @Inject
    ProductDaoU productDaoU;

    public List<ProductU> listProductU() {
        return productDaoU.listProductU(); //데이터베이스에 저장된 상품 리스트를 리턴한다.
    }

    public ProductU productU(String prodU_name){
        return productDaoU.detailProductU(prodU_name);
    }
}
