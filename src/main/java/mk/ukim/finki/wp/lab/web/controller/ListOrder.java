package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Order;
import mk.ukim.finki.wp.lab.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import java.util.List;

@Controller
@RequestMapping(value = "/listOrders.do")
public class ListOrder extends HttpServlet {

    private final OrderService orderService;

    public ListOrder(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ModelAndView listOrders() {
        ModelAndView modelAndView = new ModelAndView("listOrders");
        List<Order> orders = orderService.getOrders();
        modelAndView.addObject("orders", orders);
        return modelAndView;
    }
}
