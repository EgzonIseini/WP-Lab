package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.model.Order;

import java.util.List;

public interface OrderRepository {

    Order save(Order order);

    Order getOrder(String id);

    List<Order> getAllOrders();

}
