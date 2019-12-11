package mk.ukim.finki.wp.lab.repository.jpa.impl;

import mk.ukim.finki.wp.lab.model.Order;
import mk.ukim.finki.wp.lab.repository.OrderRepository;
import mk.ukim.finki.wp.lab.repository.jpa.JpaOrderRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

    private final JpaOrderRepository orderRepository;

    public OrderRepositoryImpl(JpaOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order getOrder(String id) {
        return orderRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
