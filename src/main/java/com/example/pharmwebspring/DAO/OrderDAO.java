package com.example.pharmwebspring.DAO;

import com.example.pharmwebspring.Model.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface OrderDAO {

    void setOrder(Order order);

    void getOrder(Order order);
}
