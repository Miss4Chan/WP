package com.example.lab.service;

import com.example.lab.model.Manufacturer;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ManufacturerService {

    public List<Manufacturer> findAll();
    Optional<Manufacturer> findById(Long id);
    Optional<Manufacturer> save(String m1, String m11, String m12);
}
