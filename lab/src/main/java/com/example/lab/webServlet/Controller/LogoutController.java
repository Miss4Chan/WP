package com.example.lab.webServlet.Controller;

import com.example.lab.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/logout")
public class LogoutController {

    private final OrderService orderService;

    public LogoutController(OrderService orderService) {
        this.orderService = orderService;//dali treba da se brishe listata? i kako?
    }

    @GetMapping
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/balloons";
    }
}
