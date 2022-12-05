package com.example.lab.repository.jpa;

import com.example.lab.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
    List<Order> findAllByDateCreatedBetween(LocalDateTime from, LocalDateTime to);
}
