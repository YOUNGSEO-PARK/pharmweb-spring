package com.example.pharmwebspring.Service.Impl;

import com.example.pharmwebspring.DAO.ProductDaoB;
import com.example.pharmwebspring.DAO.ProductDaoF;
import com.example.pharmwebspring.Model.ProductB;
import com.example.pharmwebspring.Model.ProductF;
import com.example.pharmwebspring.Service.ProductService;
import com.example.pharmwebspring.Service.ProductServiceF;

import javax.inject.Inject;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceFImpl implements ProductServiceF {
    @Inject
    ProductDaoF productDaoF;
    @Override
    public List<ProductF> listProductF() {
        return productDaoF.listProductF(); //데이터베이스에 저장된 상품 리스트를 리턴한다.
    }
    @Override
    public ProductF productF(String prodF_name){
        return productDaoF.detailProductF(prodF_name);
    }
}
