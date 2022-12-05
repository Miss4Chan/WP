package com.example.lab.service;

import com.example.lab.model.Order;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderService {
    Order placeOrder(String balloonColor, String balloonSize, LocalDateTime dateCreated);
    List<Order> listAll();
    List<Order> findAllByFilterDate(LocalDateTime dateFrom, LocalDateTime dateTo);
}
