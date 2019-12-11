package mk.ukim.finki.wp.lab.repository.jpa;

import mk.ukim.finki.wp.lab.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaOrderRepository extends JpaRepository<Order, String> {
    Optional<Order> findByClientNameAndPizzaType(String clientName, String pizzaType);
}
