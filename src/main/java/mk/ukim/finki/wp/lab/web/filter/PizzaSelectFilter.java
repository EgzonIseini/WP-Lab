package mk.ukim.finki.wp.lab.web.filter;

import mk.ukim.finki.wp.lab.model.Order;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebFilter
public class PizzaSelectFilter implements Filter
{
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException
    {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;

        String path = request.getServletPath();
        Order order = (Order)request.getSession().getAttribute("order");

        if(path.equals("") || path.equals("/pizzaSize") || path.equals("/listOrders.do")|| path.contains("/orders")) {
            filterChain.doFilter(request, response);
        } else {
            if(order == null || (order.getPizzaType().equals(""))) {
                response.sendRedirect("");
            } else {
                filterChain.doFilter(request, response);
            }
        }
    }
}
