package com.example.pharmwebspring.Service.Impl;

import com.example.pharmwebspring.DAO.ProductDaoB;
import com.example.pharmwebspring.DAO.ProductDaoT;
import com.example.pharmwebspring.Model.ProductB;
import com.example.pharmwebspring.Model.ProductT;
import com.example.pharmwebspring.Service.ProductService;
import com.example.pharmwebspring.Service.ProductServiceT;

import javax.inject.Inject;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceTImpl implements ProductServiceT {
    @Inject
    ProductDaoT productDaoT;
    @Override
    public List<ProductT> listProductT() {
        return productDaoT.listProductT(); //데이터베이스에 저장된 상품 리스트를 리턴한다.
    }
    @Override
    public ProductT productT(String prodT_name){
        return productDaoT.detailProductT(prodT_name);
    }
}
