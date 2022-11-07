package com.example.lab.webServlet.Controller;

import com.example.lab.service.BalloonService;
import com.example.lab.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/logout")
public class LogoutController {

    private final OrderService orderService;
    private final BalloonService balloonService;

    public LogoutController(OrderService orderService, BalloonService balloonService) {
        this.orderService = orderService;//dali treba da se brishe listata? i kako?
        this.balloonService = balloonService;
    }

    @GetMapping
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/balloons";
    }
}
