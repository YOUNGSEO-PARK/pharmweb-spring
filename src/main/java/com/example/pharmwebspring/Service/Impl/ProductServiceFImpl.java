package com.example.pharmwebspring.Service.Impl;

import com.example.pharmwebspring.DAO.ProductDaoB;
import com.example.pharmwebspring.DAO.ProductDaoF;
import com.example.pharmwebspring.Model.ProductB;
import com.example.pharmwebspring.Model.ProductF;

import javax.inject.Inject;
import java.util.List;

public class ProductServiceFImpl {
    @Inject
    ProductDaoF productDaoF;

    public List<ProductF> listProductF() {
        return productDaoF.listProductF(); //데이터베이스에 저장된 상품 리스트를 리턴한다.
    }

    public ProductF productF(String prodF_name){
        return productDaoF.detailProductF(prodF_name);
    }
}
