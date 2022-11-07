package com.example.lab.repository;

import com.example.lab.bootstrap.DataHolder;
import com.example.lab.model.Balloon;
import com.example.lab.model.Manufacturer;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Repository
public class BalloonRepository {
    public List<Balloon> findAllBalloons() { return DataHolder.balloonList;}
    public List<Balloon> findAllByNameOrDescription(String text) {
        return DataHolder.balloonList.stream().filter(b->b.getName().contains(text)
        || b.getDescription().contains(text)).collect(Collectors.toList());
    }
    public Optional<Balloon> save(String name, String desc,
                                  Manufacturer manufacturer) {
        DataHolder.balloonList.removeIf(i -> i.getName().equals(name)||i.getDescription().equals(desc) || i.getManufacturer().equals(manufacturer));
        Balloon balloon = new Balloon(name, desc, manufacturer);
        DataHolder.balloonList.add(balloon);
        return Optional.of(balloon);
    }
    public void deleteById(Long id)
    {
        DataHolder.counter++;
        DataHolder.balloonList.removeIf(i->i.getId().equals(id));
    }
    public Optional<Balloon> findById(Long id)
    {
        return DataHolder.balloonList.stream().filter(i->i.getId().equals(id)).findFirst();
    }
}
