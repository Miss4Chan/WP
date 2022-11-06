package com.example.lab.bootstrap;

import com.example.lab.model.Balloon;
import com.example.lab.model.Manufacturer;
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
    public static List<Manufacturer> manufacturerList = new ArrayList<>();
    @PostConstruct
    public void init()
    {
        //list filling
        Manufacturer m1=new Manufacturer("Nike","USA","NY");
        Manufacturer m2=new Manufacturer("Adidas","USA","NY");
        Manufacturer m3=new Manufacturer("Puma","USA","NY");
        Manufacturer m4=new Manufacturer("x","USA","NY");
        Manufacturer m5=new Manufacturer("y","USA","NY");
        manufacturerList.add(m1);
        manufacturerList.add(m2);
        manufacturerList.add(m3);
        manufacturerList.add(m4);
        manufacturerList.add(m5);
        balloonList.add(new Balloon("one","Desc balloon 1",m1));
        balloonList.add(new Balloon("two","Desc balloon 2",m5));
        balloonList.add(new Balloon("three","Desc balloon 3",m3));
        balloonList.add(new Balloon("four","Desc balloon 4",m1));
        balloonList.add(new Balloon("five","Desc balloon 5",m5));
        balloonList.add(new Balloon("six","Desc balloon 6",m3));
        balloonList.add(new Balloon("seven","Desc balloon 7",m4));
        balloonList.add(new Balloon("eight","Desc balloon 8",m2));
        balloonList.add(new Balloon("nine","Desc balloon 9",m3));
        balloonList.add(new Balloon("ten","Desc balloon 10",m4));
    }
}
