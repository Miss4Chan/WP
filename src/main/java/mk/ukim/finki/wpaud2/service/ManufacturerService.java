package mk.ukim.finki.wpaud2.service;

import mk.ukim.finki.wpaud2.model.Manufacturer;

import java.util.List;
import java.util.Optional;

public interface ManufacturerService {

    Optional<Manufacturer> findById(Long id);
    List<Manufacturer> findAll();
}
