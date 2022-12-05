package com.example.lab.service;

import com.example.lab.model.Balloon;

import java.util.List;
import java.util.Optional;

public interface BalloonService {
    List<Balloon> listAll();
    List<Balloon> searchByNameOrDescription(String text);
    Balloon save(String name, String desc, Long manufacturerId);
    void deleteById(Long id);
    Optional<Balloon> findById(Long id);
    int getCounter();
}