package com.example.pharmwebspring.Service.Impl;

import java.util.List;
import javax.inject.Inject;

import com.example.pharmwebspring.DAO.CartDAO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.pharmwebspring.Model.Cart;

@Repository
public class CartDAOImpl implements CartDAO {

    @Inject
    SqlSession sqlSession;

    @Override
    public List<Cart> cartMoney(){

        return null;
    }

    @Override
    public void insert(Cart cart){
        sqlSession.insert("cart.insert", cart);
    } //장바구니 담기

    @Override
    public List<Cart> listCart(String user_id){
        return sqlSession.selectList("cart.listCart", user_id);
    }

    @Override
    public void delete(String cart_code){

        sqlSession.delete("cart.delete", cart_code);
    }

    @Override
    public void deleteAll(String user_id) {
        sqlSession.delete("cart.deleteAll", user_id);
    }

    @Override
    public void update(int cart_no){

    }


    @Override
    public int countCart(String user_id, String prod_name){
        return 0;
    }


    @Override
    public void modifyCart(Cart cart){
        sqlSession.update("cart.modify", cart);
    }

    @Override
    public void updateCart(Cart cart){
        sqlSession.update("cart.sumCart", cart);
    }
}
