package com.example.pharmwebspring.Service.Impl;

import com.example.pharmwebspring.DAO.OrderDAO;
import com.example.pharmwebspring.Model.*;
import com.example.pharmwebspring.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDAO dao;

    @Override
    public void insertOrder(Order order) {
        dao.setOrder(order);
    }
}
