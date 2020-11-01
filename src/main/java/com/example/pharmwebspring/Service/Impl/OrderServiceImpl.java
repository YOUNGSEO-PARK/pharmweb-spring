package com.example.pharmwebspring.Service.Impl;

import com.example.pharmwebspring.DAO.OrderDAO;
import com.example.pharmwebspring.Model.*;
import com.example.pharmwebspring.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDAO dao;

    @Override
    public void insertOrder(Order order) {

        dao.setOrder(order);
    }

    @Override
    public List<Order> getOrderList(){

        return dao.getOrder();
    }

    @Override
    public void updateStatus(Order order){

        dao.updateOrderStatus(order);
    }

    @Override
    public void updateOrderPmsg(Order order) {

        dao.updateOrderPmsg(order);
    }

    @Override
    public void deleteOrder(Order order) {

        dao.deleteOrder(order);
    }

    @Override
    public List<Order> getOrderByIdList(String string) {

        return dao.getOrderById(string);
    }

    @Override
    public List<String> getOrderPharmList()
    {

        return dao.getOrderPharmList();
    }
}
