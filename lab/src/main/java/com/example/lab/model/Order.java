package com.example.lab.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@Table(name="balloonOrder")
public class Order {
    String balloonColor;
    String balloonSize;
    @DateTimeFormat(pattern = "yyyy-MM-dd' 'HH:mm:ss")
    private LocalDateTime dateCreated;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long orderId;

    public Order(String balloonColor, String balloonSize,LocalDateTime dateCreated) {
        this.balloonColor = balloonColor;
        this.balloonSize = balloonSize;
        this.dateCreated=dateCreated;
    }
}
