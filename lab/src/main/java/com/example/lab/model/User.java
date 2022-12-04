package com.example.lab.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
@Data
@Entity
@NoArgsConstructor
@Table(name="shop-users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String name;
    private String surname;
    private String password;
    private LocalDate dateOfBirth;
    @OneToMany
    private List<ShoppingCart> carts;
}
