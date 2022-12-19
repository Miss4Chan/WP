package com.example.lab.service.Impl;

import com.example.lab.model.Manufacturer;
import com.example.lab.repository.impl.InMemManufacturerRepository;
import com.example.lab.repository.jpa.ManufacturerRepository;
import com.example.lab.service.ManufacturerService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {
    private final ManufacturerRepository ManufacturerRepository;

    public ManufacturerServiceImpl(ManufacturerRepository ManufacturerRepository) {
        this.ManufacturerRepository = ManufacturerRepository;
    }

    @Override
    public List<Manufacturer> findAll() {
        return ManufacturerRepository.findAll();
    }

    @Override
    public Optional<Manufacturer> findById(Long id) {
        return ManufacturerRepository.findById(id);
    }

    @Override
    public Optional<Manufacturer> save(String name, String country, String address) {
        return Optional.of(ManufacturerRepository.save(new Manufacturer(name, country, address)));
    }
}