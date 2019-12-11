package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Ingredient;
import mk.ukim.finki.wp.lab.model.Pizza;
import mk.ukim.finki.wp.lab.repository.IngredientRepository;
import mk.ukim.finki.wp.lab.repository.PizzaRepository;
import mk.ukim.finki.wp.lab.service.IngredientService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository repository;
    private final PizzaRepository pizzaRepository;

    public IngredientServiceImpl(IngredientRepository repository, PizzaRepository pizzaRepository) {
        this.repository = repository;
        this.pizzaRepository = pizzaRepository;
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        return repository.save(ingredient);
    }

    @Override
    public Ingredient update(long id, String name, Boolean spicy, Float amount, Boolean veggie) {
        Ingredient ingredient = repository.find(id);

        if(name != null) ingredient.setName(name);
        if(spicy != null) ingredient.setSpicy(spicy);
        if(amount != null) ingredient.setAmount(amount);
        if(veggie != null) ingredient.setVeggie(veggie);

        return repository.update(ingredient);
    }

    @Override
    public Ingredient find(long id) {
        return repository.find(id);
    }

    @Override
    public void delete(long id) {
        repository.delete(id);
    }

    @Override
    public Page<Ingredient> getAllPaged(int page, int size) {
        return repository.findAll(page, size);
    }

    @Override
    public List<Ingredient> findAllSpicy() {
        return repository.findAllSpicy();
    }

    @Override
    public List<Pizza> findPizzasWithIngredientId(long id) {
        return pizzaRepository.getPizzasWithIngredient(id);
    }

    @Override
    public List<Ingredient> comparePizzas(Pizza pizza1, Pizza pizza2) {
        return pizza1.getIngredients()
                .stream()
                .filter(pizza2.getIngredients()::contains)
                .collect(Collectors.toList());
    }
}
