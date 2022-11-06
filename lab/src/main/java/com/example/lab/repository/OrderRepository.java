package com.example.lab.repository;

import com.example.lab.bootstrap.DataHolder;
import com.example.lab.model.Order;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepository {
    public Order placeOrder(String balloonColor,String balloonSize,String clientName, String address)
    {
        Order order=(new Order(balloonColor,balloonSize,clientName,address));
        DataHolder.orderList.add(order);
        return order;
    }
    public List<Order> listAll()
    {
        return DataHolder.orderList;
    }
}
