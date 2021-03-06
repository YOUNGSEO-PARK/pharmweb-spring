package com.example.pharmwebspring.Service.Impl;

import java.util.List;
import javax.inject.Inject;

import com.example.pharmwebspring.Service.CartService;
import org.springframework.stereotype.Service;

import com.example.pharmwebspring.Model.Cart;
import com.example.pharmwebspring.DAO.CartDAO;

@Service
public class CartServiceImpl implements CartService {

    @Inject
    CartDAO cartDAO;

    @Override
    public List<Cart> cartMoney(){

        return null;
    }

    @Override
    public void insert(Cart cart){

        cartDAO.insert(cart);
    }

    @Override
    public List<Cart> listCart(String user_id){

        return cartDAO.listCart(user_id);
    }

    @Override
    public void delete(String cart_code){

        cartDAO.delete(cart_code);
    }

    @Override
    public void deleteAll(String user_id) {
        cartDAO.deleteAll(user_id);
    }

    @Override
    public int countCart(String user_id, String prod_name){
        return 0;
    }

    @Override
    public void modifyCart(Cart cart){

        cartDAO.modifyCart(cart);
    }

    @Override
    public void updateCart(Cart cart){
        cartDAO.updateCart(cart);
    }

}
