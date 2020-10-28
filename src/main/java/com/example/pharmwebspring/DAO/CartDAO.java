package com.example.pharmwebspring.DAO;

import com.example.pharmwebspring.Model.Cart;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface CartDAO {

    void insertCart(Cart cart);
    void updateCart(Cart cart);
    List<Cart> listCart(String uid);


}
