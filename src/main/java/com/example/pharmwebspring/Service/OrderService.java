package com.example.pharmwebspring.Service;

import com.example.pharmwebspring.Model.*;

import java.util.List;

public interface OrderService {

    void insertOrder(Order order);

    List<Order> getOrderList();

    void updateStatus(Order order);

    void updateOrderPmsg(Order order);

    void deleteOrder(Order order);
}
