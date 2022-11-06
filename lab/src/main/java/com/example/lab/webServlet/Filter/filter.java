package com.example.lab.webServlet.Filter;

import com.example.lab.model.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebFilter
public class filter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        Order order = (Order) request.getSession().getAttribute("order");
        String path = request.getServletPath();

        if (!"".equals(path) && !"/balloons".equals(path) && order == null) {
            response.sendRedirect("/balloons");
        }
//        else if("/selectBalloon".equals(path) && order.getBalloonSize()==null){
//            response.sendRedirect("/selectBalloon");
    else

    {
        filterChain.doFilter(servletRequest, servletResponse);
    }

}

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
