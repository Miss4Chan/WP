package com.example.lab.service.Impl;

import com.example.lab.bootstrap.DataHolder;
import com.example.lab.model.Balloon;
import com.example.lab.model.Exceptions.ManufacturerNotFoundException;
import com.example.lab.model.Manufacturer;
import com.example.lab.repository.BalloonRepository;
import com.example.lab.repository.ManufacturerRepository;
import com.example.lab.service.BalloonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BalloonServiceImpl implements BalloonService {
    private final BalloonRepository balloonRepository;
    private final ManufacturerRepository manufacturerRepository;

    public BalloonServiceImpl(BalloonRepository balloonRepository, ManufacturerRepository manufacturerRepository, ManufacturerRepository manufacturerRepository1) {
        this.balloonRepository = balloonRepository;
        this.manufacturerRepository = manufacturerRepository1;
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
    public Optional<Balloon> save(String name, String desc, Long manufacturerId) {
        Manufacturer m = manufacturerRepository.findById(manufacturerId).
        orElseThrow(() -> new ManufacturerNotFoundException(manufacturerId));
        return balloonRepository.save(name,desc,m);
    }

    @Override
    public void deleteById(Long id) {
        balloonRepository.deleteById(id);
    }

    @Override
    public Optional<Balloon> findById(Long id) {
        return balloonRepository.findById(id);
    }

    @Override
    public int getCounter() {
        return DataHolder.counter;
    }

}
