package com.example.lab.service.Impl;

import com.example.lab.model.Order;
import com.example.lab.repository.jpa.OrderRepository;
import com.example.lab.service.OrderService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository OrderRepository;

    public OrderServiceImpl(OrderRepository OrderRepository) {
        this.OrderRepository = OrderRepository;
    }

    @Override
    public Order placeOrder(String balloonColor, String balloonSize, LocalDateTime dateCreated) {
        return OrderRepository.save(new Order(balloonColor,balloonSize,dateCreated));
    }

    @Override
    public List<Order> listAll() {
        return OrderRepository.findAll();
    }
}
