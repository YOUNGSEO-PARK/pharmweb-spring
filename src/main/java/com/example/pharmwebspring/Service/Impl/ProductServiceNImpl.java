package com.example.pharmwebspring.Service.Impl;

import com.example.pharmwebspring.DAO.ProductDaoB;
import com.example.pharmwebspring.DAO.ProductDaoN;
import com.example.pharmwebspring.Model.ProductB;
import com.example.pharmwebspring.Model.ProductN;

import javax.inject.Inject;
import java.util.List;

public class ProductServiceNImpl {
    @Inject
    ProductDaoN productDaoN;

    public List<ProductN> listProductN() {
        return productDaoN.listProductN(); //데이터베이스에 저장된 상품 리스트를 리턴한다.
    }

    public ProductN productN(String prodN_name){
        return productDaoN.detailProductN(prodN_name);
    }
}
