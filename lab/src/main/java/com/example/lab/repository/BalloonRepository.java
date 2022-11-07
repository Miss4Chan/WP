package com.example.lab.repository;

import com.example.lab.bootstrap.DataHolder;
import com.example.lab.model.Balloon;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
@Repository
public class BalloonRepository {
    public List<Balloon> findAllBalloons() { return DataHolder.balloonList;}
    public List<Balloon> findAllByNameOrDescription(String text) {
        return DataHolder.balloonList.stream().filter(b->b.getName().contains(text)
        || b.getDescription().contains(text)).collect(Collectors.toList());
    }
    public List<Balloon> listWithoutColor(String s)
    {
        return DataHolder.balloonList.stream()
                .filter(b->!b.getName().equals(s)).collect(Collectors.toList());
    }
}
