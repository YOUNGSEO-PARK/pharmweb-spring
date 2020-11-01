package com.example.pharmwebspring.Service.Impl;

import com.example.pharmwebspring.DAO.ProductDaoB;
import com.example.pharmwebspring.DAO.ProductDaoU;
import com.example.pharmwebspring.Model.ProductB;
import com.example.pharmwebspring.Model.ProductU;
import com.example.pharmwebspring.Service.ProductService;
import com.example.pharmwebspring.Service.ProductServiceU;

import javax.inject.Inject;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceUImpl implements ProductServiceU {
    @Inject
    ProductDaoU productDaoU;
    @Override
    public List<ProductU> listProductU() {
        return productDaoU.listProductU(); //데이터베이스에 저장된 상품 리스트를 리턴한다.
    }
    @Override
    public ProductU productU(String prodU_name){
        return productDaoU.detailProductU(prodU_name);
    }
}
