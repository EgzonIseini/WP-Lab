package mk.ukim.finki.wp.lab.repository.inmemory;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Order;
import mk.ukim.finki.wp.lab.repository.OrderRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Profile("in-memory-rep")
@Repository
public class InMemoryOrderRepositoryImpl implements OrderRepository {

    @Override
    public Order save(Order order) {
        DataHolder.orderList.put(order.getOrderId(), order);
        return order;
    }

    @Override
    public Order getOrder(String id) {
        return null;
    }

    @Override
    public List<Order> getAllOrders() {
        return new ArrayList<>(DataHolder.orderList.values());
    }
}
