package com.example.pharmwebspring.DAO;

import java.util.List;
import com.example.pharmwebspring.Model.Cart;

public interface CartDAO {
    List<Cart> cartMoney();
    void insert(Cart cart); //장바구니 추가
    List<Cart> listCart(String user_id);  //장바구니 목록
    void delete(String cart_code);  //장바구니 목록 삭제
    void deleteAll(String user_id);
    void update(int cart_no);
    int countCart(String user_id, String prod_name); //장바구니 상품 갯수
    void updateCart(Cart cart); //장바구니 수정
    void modifyCart(Cart cart);
}
