package com.example.pharmwebspring.Service.Impl;

import com.example.pharmwebspring.DAO.ProductDaoB;
import com.example.pharmwebspring.DAO.ProductDaoT;
import com.example.pharmwebspring.Model.ProductB;
import com.example.pharmwebspring.Model.ProductT;

import javax.inject.Inject;
import java.util.List;

public class ProductServiceTImpl {
    @Inject
    ProductDaoT productDaoT;

    public List<ProductT> listProductT() {
        return productDaoT.listProductT(); //데이터베이스에 저장된 상품 리스트를 리턴한다.
    }

    public ProductT productT(String prodT_name){
        return productDaoT.detailProductT(prodT_name);
    }
}
