package com.example.lab.service;

import com.example.lab.model.Order;

import java.util.List;

public interface OrderService {
    Order placeOrder(String balloonColor,String balloonSize, String clientName, String address);
    public List<Order> listAll();
}
