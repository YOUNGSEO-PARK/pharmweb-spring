package com.example.pharmwebspring.Service.Impl;

import com.example.pharmwebspring.DAO.ProductDao;
import com.example.pharmwebspring.DAO.ProductDaoB;
import com.example.pharmwebspring.Model.Product;
import com.example.pharmwebspring.Model.ProductB;
import com.example.pharmwebspring.Service.ProductService;
import com.example.pharmwebspring.Service.ProductServiceB;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class ProductServiceBImpl implements ProductServiceB {
    @Inject
    ProductDaoB productDaoB;

    @Override
    public List<ProductB> listProductB() {
        return productDaoB.listProductB(); //데이터베이스에 저장된 상품 리스트를 리턴한다.
    }

    @Override
    public ProductB productB(String prodB_name){
        return productDaoB.detailProductB(prodB_name);
    }
}
