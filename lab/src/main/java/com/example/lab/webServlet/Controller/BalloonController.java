package com.example.lab.webServlet.Controller;

import com.example.lab.model.Balloon;
import com.example.lab.model.Manufacturer;
import com.example.lab.model.Order;
import com.example.lab.service.BalloonService;
import com.example.lab.service.ManufacturerService;
import com.example.lab.service.OrderService;
import com.example.lab.service.UserService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping(value = {"/", "/balloons"})
public class BalloonController {
    private final BalloonService balloonService;
    private final ManufacturerService manufacturerService;
    private  final OrderService orderService;
    private final UserService userService;

    public BalloonController(BalloonService balloonService, ManufacturerService manufacturerService, OrderService orderService, UserService userService) {
        this.balloonService = balloonService;
        this.manufacturerService = manufacturerService;
        this.orderService = orderService;
        this.userService = userService;
    }

    @GetMapping
    public String getBalloonsPage(@RequestParam(required = false) String error, Model model)
    {
        List<Balloon> balloons = this.balloonService.listAll();
        int counter = balloonService.getCounter();
        model.addAttribute("balloons", balloons);
        model.addAttribute("counter",counter);
        return "listBalloons";
    }
    @GetMapping("/edit-balloon/{id}")
    public String getEditBalloonPage(@PathVariable Long id, Model model) {
        if(this.balloonService.findById(id).isPresent()){
            Balloon balloon = this.balloonService.findById(id).get();
            List<Manufacturer> manufacturers = this.manufacturerService.findAll();
            model.addAttribute("manufacturers", manufacturers);
            model.addAttribute("balloon", balloon);
            return "add-balloon";
        }
        return "redirect:/products?error=ProductNotFound";
    }
    @GetMapping("/add-balloon")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String getAddBalloonPage(Model model)
    {
        List<Manufacturer> manufacturers = this.manufacturerService.findAll();
        model.addAttribute("manufacturers", manufacturers);
        return "add-balloon";
    }
    @PostMapping("/add")
    public String saveBalloon(@RequestParam(required = false) Long id,
                              @RequestParam String name,
                              @RequestParam String description,
                              @RequestParam Long manufacturer)
    {
        if (id != null)
            balloonService.edit(id, name, description, manufacturer);
        else
            this.balloonService.save(name,description, manufacturer);
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
        Order order = new Order(color,"",null);
        request.getSession().setAttribute("order",order);
        return "selectBalloonSize";
    }
    @PostMapping("/selectBalloonSize")
    public String chosenSize(HttpServletRequest request, Model model)
    {
        String size = request.getParameter("size");
        Order order = (Order) request.getSession().getAttribute("order");
        order.setBalloonSize(size);
        request.getSession().setAttribute("order",order);
        model.addAttribute("users",userService.listAll());
        return "deliveryInfo";
    }
    @PostMapping("/deliveryInfo")
    public String deliveryInfo(HttpServletRequest request, Model model
    ,@RequestParam("dateCreated") @DateTimeFormat
            (iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateCreated)
    {
        String ipAddress = request.getRemoteAddr();
        String clientBrowser = request.getHeader("User-Agent");
        Order order = (Order) request.getSession().getAttribute("order");
        request.getSession().setAttribute("dateCreated", dateCreated);
        order.setDateCreated(dateCreated);
        request.getSession().setAttribute("order",order);
        orderService.placeOrder(order.getBalloonColor(),order.getBalloonSize(),order.getDateCreated());
        model.addAttribute("ipAddress",ipAddress);
        model.addAttribute("clientBrowser",clientBrowser);
        return "confirmationInfo";
    }
    @GetMapping("/orders")
    public String getOrdersPage(Model model)
    {
        List<Order> orders = orderService.listAll();
        model.addAttribute("orders",orders);
        return "userOrders";
    }
}
