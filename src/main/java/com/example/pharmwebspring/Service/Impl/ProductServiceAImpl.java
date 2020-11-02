package com.example.pharmwebspring.Service.Impl;

import com.example.pharmwebspring.DAO.ProductDaoA;
import com.example.pharmwebspring.Model.ProductA;
import com.example.pharmwebspring.Service.ProductServiceA;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class ProductServiceAImpl implements ProductServiceA {
    @Inject
    ProductDaoA productDaoA;

    @Override
    public List<ProductA> listProductA() {
        return productDaoA.listProductA(); //데이터베이스에 저장된 상품 리스트를 리턴한다.
    }

    @Override
    public ProductA productA(String prodA_name){
        return productDaoA.detailProductA(prodA_name);
    }
}
