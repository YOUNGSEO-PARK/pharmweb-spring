package com.example.pharmwebspring.DAO;

import com.example.pharmwebspring.Model.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface OrderDAO {

    void setOrder(Order order);

    List<Order> getOrder();

    void updateOrderStatus(Order order);

    void deleteOrder(Order order);

    void updateOrderPmsg(Order order);

    String getOrderPharmList();
}
