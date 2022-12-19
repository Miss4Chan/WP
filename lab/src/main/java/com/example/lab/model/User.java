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
    private String name;
    @Convert(converter = UserFullNameConverter.class)
    private UserFullname userFullname;
    private String surname;
    private String password;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOfBirth;
    @OneToMany
    private List<ShoppingCart> carts;

    public User(String username, UserFullname userFullname, String password, LocalDate dateOfBirth) {
        this.username = username;
        this.userFullname = userFullname;
        this.name=userFullname.getName();
        this.surname=userFullname.getSurname();
        this.password = password;
        this.dateOfBirth = dateOfBirth;
    }

    public User(String username, String name, String surname, String password, LocalDate dateOfBirth) {
        this.username = username;
        this.userFullname = new UserFullname(name,surname);
        this.name=name;
        this.surname=surname;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return userFullname.getName();
    }

    public String getSurname() {
        return userFullname.getSurname();
    }
}
