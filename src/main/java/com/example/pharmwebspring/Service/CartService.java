package com.example.pharmwebspring.Service;

import com.example.pharmwebspring.Model.Cart;

import java.util.List;

public interface CartService {

    void insertCart(Cart cart);

    List<Cart> listCart(String uid);

    int countCart(String prod_name, String uid);

    void updateCart(Cart cart);
}
