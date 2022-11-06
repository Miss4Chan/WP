package com.example.lab.service;

import com.example.lab.model.Order;

public interface OrderService {
    Order placeOrder(String balloonColor,String balloonSize, String clientName, String address);
}
