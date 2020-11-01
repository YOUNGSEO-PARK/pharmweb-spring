package com.example.pharmwebspring.Service;

import java.util.List;
import com.example.pharmwebspring.Model.Cart;
import com.sun.source.tree.VariableTree;

public interface CartService {
    List<Cart> cartMoney();

    void insert(Cart cart);

    List<Cart> listCart(String user_id);

    void delete(String cart_code);

    void deleteAll(String user_id);
    int countCart(String user_id, String prod_name);

    void modifyCart(Cart cart);

    void updateCart(Cart cart);

}