package com.example.lab.bootstrap;

import com.example.lab.model.Balloon;
import com.example.lab.model.Order;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class DataHolder {
    public static List<Balloon> balloonList = new ArrayList<>();
    public static List<Order> orderList = new ArrayList<>();
    @PostConstruct
    public void init()
    {
        //list filling
    }
}
