package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findByClientNameAndPizzaType(String clientName, String pizzaType);
}
