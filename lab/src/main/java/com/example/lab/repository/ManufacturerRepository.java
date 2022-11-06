package com.example.lab.repository;

import com.example.lab.bootstrap.DataHolder;
import com.example.lab.model.Manufacturer;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ManufacturerRepository {
    public List<Manufacturer> findAll()
    {
        return DataHolder.manufacturerList;
    }
    public Optional<Manufacturer> findById(Long id) {
        return DataHolder.manufacturerList.stream().filter(i -> i.getId().equals(id)).findFirst();
    }
}
