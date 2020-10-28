//package com.example.pharmwebspring.Service.Impl;
//
//import com.example.pharmwebspring.DAO.CartDAO;
//import com.example.pharmwebspring.Model.Cart;
//import com.example.pharmwebspring.Service.CartService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class CartServiceImpl implements CartService {
//
//    @Autowired
//    private CartDAO dao;
//
//    @Override
//    public void insertCart(Cart cart){
//
//        dao.insertCart(cart);
//    }
//
//    @Override
//    public List<Cart> listCart(String uid){
//
//        return dao.listCart(uid);
//    }
//
//    @Override
//    public int countCart(String prod_name, String uid) {
//
//        return 0;
//    }
//
//    @Override
//    public void updateCart(Cart cart) {
//
//        dao.updateCart(cart);
//    }
//
//}
