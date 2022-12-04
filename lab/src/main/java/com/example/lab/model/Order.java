package com.example.lab.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class Order {
    String balloonColor;
    String balloonSize;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long orderId;

    public Order(String balloonColor, String balloonSize) {
        this.balloonColor = balloonColor;
        this.balloonSize = balloonSize;
        this.orderId = (long) (Math.random() * 1000);
    }
}
