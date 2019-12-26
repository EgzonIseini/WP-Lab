package mk.ukim.finki.wp.lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;

    private String pizzaType;

    private String pizzaSize;

    private String clientName;

    private String clientAddress;

    public Order(String clientName, String clientAddress, String pizzaType, String pizzaSize) {
        this.clientName = clientName;
        this.clientAddress = clientAddress;
        this.pizzaType = pizzaType;
        this.pizzaSize = pizzaSize;
    }
}
