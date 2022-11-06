package com.example.lab.service.Impl;

import com.example.lab.model.Order;
import com.example.lab.repository.OrderRepository;
import com.example.lab.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order placeOrder(String balloonColor,String balloonSize, String clientName, String address) {
        return orderRepository.placeOrder(balloonColor,balloonSize,clientName,address);
    }

    @Override
    public List<Order> listAll() {
        return orderRepository.listAll();
    }
}
