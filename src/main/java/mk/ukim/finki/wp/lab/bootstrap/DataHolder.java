package mk.ukim.finki.wp.lab.bootstrap;

import mk.ukim.finki.wp.lab.model.Order;
import mk.ukim.finki.wp.lab.model.Pizza;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DataHolder {

    public static final List<Pizza> pizzaList = new ArrayList<>();
    public static final Map<Long, Order> orderList = new HashMap<>();

    @PostConstruct
    public void init() {
        /*pizzaList.add(new Pizza("Margherita", "Margherita (tomato sauce, mozzarella)"));
        pizzaList.add(new Pizza("Carbonara", "Carbonara (fresh cream, mozzarella, bacon)"));
        pizzaList.add(new Pizza("Vegetariana","Vegetariana (tomato sauce, mushrooms)"));
        pizzaList.add(new Pizza("Calzone","Calzone (Pizza dough, ricotta, pepperoni, pizza sauce, olive oil)"));
        pizzaList.add(new Pizza("Cheddar","Cheddar (cheddar, tomato sauce)"));
        pizzaList.add(new Pizza("Capricciosa","Capricciosa (tomato sauce, cheese, ham)"));
        pizzaList.add(new Pizza("Burger Classic","Burger Classic (barbecue sauce, beef, mozzarella, onions)"));
        pizzaList.add(new Pizza("Boston Barbecue","Burger Barbecue (ham, chicken meat, onions)"));
        pizzaList.add(new Pizza("Pepperoni","Pepperoni (tomato sauce, mozzarella, sausage)"));
        pizzaList.add(new Pizza("Quattro Formaggi","Quattro Formaggi (Taleggio, Mascarpone, Gorgonzola, Parmesan)"));
        pizzaList.add(new Pizza("Domashna", "Domashna (Pepperoni, Mozarella, Feta Cheese, Onions, Tomato Sauce, Peppers)"));
        pizzaList.add(new Pizza("Fungi", "Fungi (Mushrooms, Mozarella, tomato sauce"));*/
    }
}
