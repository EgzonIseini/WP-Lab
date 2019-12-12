package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Pizza;

import java.util.List;

public interface PizzaService {

    Pizza createPizza(String name, List<Long> ingredients);

    Pizza modifyPizza(String id, String description, Boolean veggie, List<Long> ingredients);

    Pizza save(Pizza pizza);

    void deleteById(String name);

    List<Pizza> findAll();

    Pizza findById(String id);

    List<Pizza> findPizzasByIngredientsLessThan(int ingredientsNumber);

    List<Pizza> findPizzasWithIngredientId(long id);
}
