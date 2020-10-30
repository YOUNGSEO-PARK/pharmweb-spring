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
    public void delete(int cart_no){
        cartDAO.delete(cart_no);
    }

    @Override
    public int sumMoney(String user_id){
        return cartDAO.sumMoney(user_id);
    }

    @Override
    public int countCart(String user_id, String prod_name){
        return 0;
    }

    @Override
    public void modifyCart(Cart cart){
        cartDAO.modifyCart(cart);
    }

}
