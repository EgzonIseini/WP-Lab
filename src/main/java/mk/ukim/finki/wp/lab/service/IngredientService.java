package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Ingredient;
import mk.ukim.finki.wp.lab.model.Pizza;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IngredientService {

    Ingredient save(Ingredient ingredient);

    Ingredient update(long id, String name, Boolean spicy, Float amount, Boolean veggie);

    Ingredient find(long id);

    void delete(long id);

    Page<Ingredient> getAllPaged(int page, int size);

    List<Ingredient> findAllSpicy();

    List<Pizza> findPizzasWithIngredientId(long id);

    List<Ingredient> comparePizzas(Pizza pizza1, Pizza pizza2);

}
