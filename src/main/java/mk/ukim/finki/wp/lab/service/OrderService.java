package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Order;

import java.util.List;

public interface OrderService{

    Order placeOrder(Order order);

    Order getOrder(String id);

    List<Order> getOrders();
}
