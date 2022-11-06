package com.example.lab.model;

import lombok.Data;

@Data
public class Balloon {
    Long id;
    String name;
    String description;
    Manufacturer manufacturer;

    public Balloon(String name, String description,Manufacturer manufacturer) {
        this.id = (long) (Math.random() * 1000);
        this.name = name;
        this.manufacturer=manufacturer;
        this.description = description;
    }

}