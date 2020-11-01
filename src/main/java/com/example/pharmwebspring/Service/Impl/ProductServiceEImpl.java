package com.example.pharmwebspring.Service.Impl;

import com.example.pharmwebspring.DAO.ProductDaoB;
import com.example.pharmwebspring.DAO.ProductDaoE;
import com.example.pharmwebspring.Model.ProductB;
import com.example.pharmwebspring.Model.ProductE;

import javax.inject.Inject;
import java.util.List;

public class ProductServiceEImpl {
    @Inject
    ProductDaoE productDaoE;

    public List<ProductE> listProductE() {
        return productDaoE.listProductE(); //데이터베이스에 저장된 상품 리스트를 리턴한다.
    }

    public ProductE productE(String prodE_name){
        return productDaoE.detailProductE(prodE_name);
    }
}
