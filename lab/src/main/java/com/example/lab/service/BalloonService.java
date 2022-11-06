package com.example.lab.service;

import com.example.lab.model.Balloon;
import org.springframework.stereotype.Service;

import javax.swing.plaf.OptionPaneUI;
import java.util.List;
import java.util.Optional;

public interface BalloonService {
    List<Balloon> listAll();
    List<Balloon> searchByNameOrDescription(String text);
    Optional<Balloon> save(String name, String desc, Long manufacturerId);
    void deleteById(Long id);
}
