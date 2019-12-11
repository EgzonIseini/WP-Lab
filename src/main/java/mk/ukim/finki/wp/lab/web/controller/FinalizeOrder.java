package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Order;
import mk.ukim.finki.wp.lab.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class FinalizeOrder {

    private final OrderService orderService;

    public FinalizeOrder(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/PlaceOrder.do")
    public String placeOrder(@SessionAttribute("order") Order order) {
        orderService.placeOrder(order);
        return "orderConfirmed";
    }

    @PostMapping("/ClearOrder.do")
    public String clearOrder() {
        return "orderReset";
    }
}
