package com.example.lab.service;

import com.example.lab.model.Manufacturer;

import java.util.List;
import java.util.Optional;

public interface ManufacturerService {

    public List<Manufacturer> findAll();
    Optional<Manufacturer> findById(Long id);
}
