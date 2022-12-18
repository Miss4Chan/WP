package com.example.lab.service.Impl;

import com.example.lab.bootstrap.DataHolder;
import com.example.lab.model.Balloon;
import com.example.lab.model.Exceptions.BalloonNotFoundException;
import com.example.lab.model.Exceptions.ManufacturerNotFoundException;
import com.example.lab.model.Manufacturer;
import com.example.lab.repository.jpa.BalloonRepository;
import com.example.lab.repository.jpa.ManufacturerRepository;
import com.example.lab.service.BalloonService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BalloonServiceImpl implements BalloonService {
    private final BalloonRepository balloonRepository;
    private final ManufacturerRepository manufacturerRepository;

    public BalloonServiceImpl(BalloonRepository BalloonRepository, ManufacturerRepository ManufacturerRepository) {
        this.balloonRepository = BalloonRepository;
        this.manufacturerRepository = ManufacturerRepository;
    }
    @Override
    @Transactional
    public Optional<Balloon> edit(Long id, String name, String description, Long manufacturerId) {
        Balloon balloon = balloonRepository.findById(id)
                .orElseThrow(() -> new BalloonNotFoundException(id));
        Manufacturer manufacturer = manufacturerRepository.findById(manufacturerId)
                .orElseThrow(() -> new ManufacturerNotFoundException(manufacturerId));

        balloon.setName(name);
        balloon.setDescription(description);
        balloon.setManufacturer(manufacturer);
        return Optional.of(balloonRepository.save(balloon));
    }

    @Override
    public List<Balloon> listAll() {
        return balloonRepository.findAll();
    }

    @Override
    public List<Balloon> searchByNameOrDescription(String text) {
        return balloonRepository.findAllByNameOrDescription(text,text);
    }

    @Override
    public Balloon save(String name, String desc, Long manufacturerId) {
        Manufacturer m = manufacturerRepository.findById(manufacturerId).
        orElseThrow(() -> new ManufacturerNotFoundException(manufacturerId));
        return balloonRepository.save(new Balloon(name,desc,m));
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
