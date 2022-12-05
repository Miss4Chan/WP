package com.example.lab.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name="balloon-table")
public class Balloon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String description;

    @ManyToOne
    Manufacturer manufacturer;

    public Balloon(String name, String description,Manufacturer manufacturer) {
        this.name = name;
        this.manufacturer=manufacturer;
        this.description = description;
    }

}
