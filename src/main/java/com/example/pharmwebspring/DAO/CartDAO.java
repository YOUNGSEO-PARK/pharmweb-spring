package com.example.pharmwebspring.DAO;

import com.example.pharmwebspring.Model.Cart;

import java.util.List;



public interface CartDAO {
    void insert(Cart cart);

    List<Cart> listCart(String uid);
}
