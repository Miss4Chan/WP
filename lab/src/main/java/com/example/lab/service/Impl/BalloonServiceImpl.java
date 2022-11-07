package com.example.lab.service.Impl;

import com.example.lab.model.Balloon;
import com.example.lab.repository.BalloonRepository;
import com.example.lab.service.BalloonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BalloonServiceImpl implements BalloonService {
    private final BalloonRepository balloonRepository;

    public BalloonServiceImpl(BalloonRepository balloonRepository) {
        this.balloonRepository = balloonRepository;
    }

    @Override
    public List<Balloon> listAll() {
        return balloonRepository.findAllBalloons();
    }

    @Override
    public List<Balloon> searchByNameOrDescription(String text) {
        return balloonRepository.findAllByNameOrDescription(text);
    }

    @Override
    public List<Balloon> listWithoutColor(String s) {
        return balloonRepository.listWithoutColor(s);
    }

}
