package com.example.pharmwebspring.Service.Impl;

import com.example.pharmwebspring.DAO.ProductDaoB;
import com.example.pharmwebspring.DAO.ProductDaoZ;
import com.example.pharmwebspring.Model.ProductB;
import com.example.pharmwebspring.Model.ProductZ;
import com.example.pharmwebspring.Service.ProductService;
import com.example.pharmwebspring.Service.ProductServiceZ;

import javax.inject.Inject;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceZImpl implements ProductServiceZ {
    @Inject
    ProductDaoZ productDaoZ;
    @Override
    public List<ProductZ> listProductZ() {
        return productDaoZ.listProductZ(); //데이터베이스에 저장된 상품 리스트를 리턴한다.
    }
    @Override
    public ProductZ productZ(String prodZ_name){
        return productDaoZ.detailProductZ(prodZ_name);
    }
}
