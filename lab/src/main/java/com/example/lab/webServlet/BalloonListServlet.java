package com.example.lab.webServlet;

import com.example.lab.model.Order;
import com.example.lab.service.BalloonService;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet(name="balloon-list-servlet",urlPatterns = "")
public class BalloonListServlet extends HttpServlet {
    private final BalloonService balloonService;
    private final SpringTemplateEngine springTemplateEngine;

    public BalloonListServlet(BalloonService balloonService, SpringTemplateEngine springTemplateEngine) {
        this.balloonService = balloonService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context = new WebContext(req,resp,req.getServletContext());
        String colorFilter = req.getParameter("colorFilter");
        if(colorFilter==null)
            context.setVariable("balloons", this.balloonService.listAll());
        else
            context.setVariable("balloons" , this.balloonService.listWithoutColor(colorFilter));
        this.springTemplateEngine.process("listBalloons.html", context,resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String color = req.getParameter("color");
        Long Id = new Random().nextLong();
        Order order = new Order(color,"","","",Id);
        req.getSession().setAttribute("order",order);
        resp.sendRedirect("/selectBalloon");
    }
}
