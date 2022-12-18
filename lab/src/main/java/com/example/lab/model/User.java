package com.example.lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="shop-users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
//    private String name;
    @Convert(converter = UserFullNameConverter.class)
    private UserFullname userFullname;
 //   private String surname;
    private String password;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOfBirth;
    @OneToMany
    private List<ShoppingCart> carts;

    public User(String username, UserFullname userFullname, String password, LocalDate dateOfBirth) {
        this.username = username;
        this.userFullname = userFullname;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
    }
}
