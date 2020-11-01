package com.example.pharmwebspring.Service.Impl;

import com.example.pharmwebspring.DAO.ProductDaoB;
import com.example.pharmwebspring.DAO.ProductDaoH;
import com.example.pharmwebspring.Model.ProductB;
import com.example.pharmwebspring.Model.ProductH;

import javax.inject.Inject;
import java.util.List;

public class ProductServiceHImpl {
    @Inject
    ProductDaoH productDaoH;

    public List<ProductH> listProductH() {
        return productDaoH.listProductH(); //데이터베이스에 저장된 상품 리스트를 리턴한다.
    }

    public ProductH productH(String prodH_name){
        return productDaoH.detailProductH(prodH_name);
    }
}
