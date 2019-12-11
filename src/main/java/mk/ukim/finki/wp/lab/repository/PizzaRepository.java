package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.model.Pizza;

import java.util.List;

public interface PizzaRepository {

    Pizza save(Pizza pizza);

    void delete(Pizza pizza);

    void deleteById(String name);

    List<Pizza> findAll();

    Pizza findById(String id);

    List<Pizza> findPizzasByIngredientsLessThan(int ingredientsNumber);

    List<Pizza> getPizzasWithIngredient(long id);
}
