package com.example.lab.repository.jpa;

import com.example.lab.model.Balloon;
import com.example.lab.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BalloonRepository extends JpaRepository<Balloon,Long> {
    public List<Balloon> findAllByNameOrDescription(String name,String desc);
}
