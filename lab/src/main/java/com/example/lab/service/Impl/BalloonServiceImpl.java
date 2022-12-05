package com.example.lab.service.Impl;

import com.example.lab.bootstrap.DataHolder;
import com.example.lab.model.Balloon;
import com.example.lab.model.Exceptions.ManufacturerNotFoundException;
import com.example.lab.model.Manufacturer;
import com.example.lab.repository.jpa.BalloonRepository;
import com.example.lab.repository.jpa.ManufacturerRepository;
import com.example.lab.service.BalloonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BalloonServiceImpl implements BalloonService {
    private final BalloonRepository BalloonRepository;
    private final ManufacturerRepository ManufacturerRepository;

    public BalloonServiceImpl(BalloonRepository BalloonRepository, ManufacturerRepository ManufacturerRepository) {
        this.BalloonRepository = BalloonRepository;
        this.ManufacturerRepository = ManufacturerRepository;
    }

    @Override
    public List<Balloon> listAll() {
        return BalloonRepository.findAll();
    }

    @Override
    public List<Balloon> searchByNameOrDescription(String text) {
        return BalloonRepository.findAllByNameOrDescription(text,text);
    }

    @Override
    public Balloon save(String name, String desc, Long manufacturerId) {
        Manufacturer m = ManufacturerRepository.findById(manufacturerId).
        orElseThrow(() -> new ManufacturerNotFoundException(manufacturerId));
        return BalloonRepository.save(new Balloon(name,desc,m));
    }

    @Override
    public void deleteById(Long id) {
        BalloonRepository.deleteById(id);
    }

    @Override
    public Optional<Balloon> findById(Long id) {
        return BalloonRepository.findById(id);
    }

    @Override
    public int getCounter() {
        return DataHolder.counter;
    }

}
