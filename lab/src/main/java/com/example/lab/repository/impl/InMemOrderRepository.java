package com.example.lab.repository.impl;

import com.example.lab.bootstrap.DataHolder;
import com.example.lab.model.Order;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class InMemOrderRepository {
    public Order placeOrder(String balloonColor, String balloonSize, LocalDateTime localDateTime)
    {
        Order order=(new Order(balloonColor,balloonSize,localDateTime));
        DataHolder.orderList.add(order);
        return order;
    }
    public List<Order> listAll()
    {
        return DataHolder.orderList;
    }
}
