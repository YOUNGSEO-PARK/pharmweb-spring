package com.example.pharmwebspring.Service.Impl;
import java.util.List;

import javax.inject.Inject;

import com.example.pharmwebspring.Service.ProductService;
import org.springframework.stereotype.Service;

import com.example.pharmwebspring.Model.Product;
import com.example.pharmwebspring.DAO.ProductDao;

@Service
public class ProductServiceImpl implements ProductService {

    //Service에서는 model(DAO)를 받으므로 의존성을 주입해야한다.
    @Inject
    ProductDao productDao;

    @Override
    public List<Product> listProduct() {
        return productDao.listProduct(); //데이터베이스에 저장된 상품 리스트를 리턴한다.
    }
}

