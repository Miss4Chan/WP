package com.example.lab.service;

import com.example.lab.model.Balloon;
import org.springframework.stereotype.Service;

import java.util.List;
public interface BalloonService {
    List<Balloon> listAll();
    List<Balloon> searchByNameOrDescription(String text);
     List<Balloon> listWithoutColor(String s);
}
