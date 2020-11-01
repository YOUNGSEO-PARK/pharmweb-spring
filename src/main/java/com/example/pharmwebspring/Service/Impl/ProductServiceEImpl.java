package com.example.pharmwebspring.Service.Impl;

import com.example.pharmwebspring.DAO.ProductDaoB;
import com.example.pharmwebspring.DAO.ProductDaoE;
import com.example.pharmwebspring.Model.ProductB;
import com.example.pharmwebspring.Model.ProductE;
import com.example.pharmwebspring.Service.ProductService;
import com.example.pharmwebspring.Service.ProductServiceE;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class ProductServiceEImpl implements ProductServiceE {
    @Inject
    ProductDaoE productDaoE;
    @Override
    public List<ProductE> listProductE() {
        return productDaoE.listProductE(); //데이터베이스에 저장된 상품 리스트를 리턴한다.
    }
    @Override
    public ProductE productE(String prodE_name){
        return productDaoE.detailProductE(prodE_name);
    }
}
