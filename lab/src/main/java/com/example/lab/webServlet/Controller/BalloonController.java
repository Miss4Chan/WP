package com.example.lab.webServlet.Controller;

import com.example.lab.model.Balloon;
import com.example.lab.model.Manufacturer;
import com.example.lab.model.Order;
import com.example.lab.service.BalloonService;
import com.example.lab.service.ManufacturerService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/balloons")
public class BalloonController {
    private final BalloonService balloonService;
    private final ManufacturerService manufacturerService;

    public BalloonController(BalloonService balloonService, ManufacturerService manufacturerService) {
        this.balloonService = balloonService;
        this.manufacturerService = manufacturerService;
    }

    @GetMapping
    public String getBalloonsPage(@RequestParam(required = false) String error, Model model)
    {
        List<Balloon> balloons = this.balloonService.listAll();
        model.addAttribute("balloons", balloons);
        return "listBalloons";
    }
    @PostMapping("/balloons/add")
    public String saveBalloon(@RequestParam String name,
                              @RequestParam String desc,
                              @RequestParam Long manufacturerId)
    {
        this.balloonService.save(name,desc,manufacturerId);
        return "redirect:/balloons";
    }
    @DeleteMapping("/delete/{id}")
    public String deleteBalloon(@PathVariable Long id)
    {
        balloonService.deleteById(id);
        return "redirect:/balloons";
    }
    @PostMapping("/selectBalloon")
    public String chosenColor(HttpServletRequest request, Model model)
    {
        String color = request.getParameter("color");
        Long Id = new Random().nextLong();
        Order order = new Order(color,"","","",Id);
        request.getSession().setAttribute("order",order);
        return "selectBalloonSize";
    }
}
