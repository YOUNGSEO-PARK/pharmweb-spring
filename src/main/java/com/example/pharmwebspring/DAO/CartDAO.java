package com.example.pharmwebspring.DAO;

import java.util.List;
import com.example.pharmwebspring.Model.Cart;

public interface CartDAO {
    List<Cart> cartMoney();
    void insert(Cart cart);
    List<Cart> listCart(String user_id);
    void delete(int cart_no);
    void deleteAll(String user_id);
    void update(int cart_no);
    int sumMoney(String user_id);
    int countCart(String user_id, String prod_name);
    void updateCart(Cart cart);
    void modifyCart(Cart cart);
}
