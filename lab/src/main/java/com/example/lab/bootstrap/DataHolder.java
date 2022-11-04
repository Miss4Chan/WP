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
        balloonList.add(new Balloon("one","Desc balloon 1"));
        balloonList.add(new Balloon("two","Desc balloon 2"));
        balloonList.add(new Balloon("three","Desc balloon 3"));
        balloonList.add(new Balloon("four","Desc balloon 4"));
        balloonList.add(new Balloon("five","Desc balloon 5"));
        balloonList.add(new Balloon("six","Desc balloon 6"));
        balloonList.add(new Balloon("seven","Desc balloon 7"));
        balloonList.add(new Balloon("eight","Desc balloon 8"));
        balloonList.add(new Balloon("nine","Desc balloon 9"));
        balloonList.add(new Balloon("ten","Desc balloon 10"));
    }
}
