package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Order;
import mk.ukim.finki.wp.lab.model.exceptions.OrderNotExists;
import mk.ukim.finki.wp.lab.repository.OrderRepository;
import mk.ukim.finki.wp.lab.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order placeOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order getOrder(long id) {
        return orderRepository.findById(id).orElseThrow(OrderNotExists::new);
    }

    @Override
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }
}
