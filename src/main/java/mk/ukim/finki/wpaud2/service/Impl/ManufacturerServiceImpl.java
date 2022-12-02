package mk.ukim.finki.wpaud2.service.Impl;


import mk.ukim.finki.wpaud2.model.Manufacturer;
import mk.ukim.finki.wpaud2.repository.InMemoryManufacturerRepository;
import mk.ukim.finki.wpaud2.service.ManufacturerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    private final InMemoryManufacturerRepository manufacturerRepository;

    public ManufacturerServiceImpl(InMemoryManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public Optional<Manufacturer> findById(Long id) {
        return this.manufacturerRepository.findById(id);
    }

    @Override
    public List<Manufacturer> findAll() {
        return this.manufacturerRepository.findAll();
    }

    @Override
    public Optional<Manufacturer> save(String name, String address) {
        return manufacturerRepository.save(name,address);
    }

    @Override
    public boolean deleteById(Long id) {
        return manufacturerRepository.deleteById(id);
    }
}
