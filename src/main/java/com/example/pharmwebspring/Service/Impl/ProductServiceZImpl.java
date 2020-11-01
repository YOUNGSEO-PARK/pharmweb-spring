package com.example.pharmwebspring.Service.Impl;

import com.example.pharmwebspring.DAO.ProductDaoB;
import com.example.pharmwebspring.DAO.ProductDaoZ;
import com.example.pharmwebspring.Model.ProductB;
import com.example.pharmwebspring.Model.ProductZ;

import javax.inject.Inject;
import java.util.List;

public class ProductServiceZImpl {
    @Inject
    ProductDaoZ productDaoZ;

    public List<ProductZ> listProductZ() {
        return productDaoZ.listProductZ(); //데이터베이스에 저장된 상품 리스트를 리턴한다.
    }

    public ProductZ productZ(String prodZ_name){
        return productDaoZ.detailProductZ(prodZ_name);
    }
}
