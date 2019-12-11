package mk.ukim.finki.wp.lab.repository.jpa.impl;

import mk.ukim.finki.wp.lab.model.Pizza;
import mk.ukim.finki.wp.lab.model.exceptions.PizzaNotFound;
import mk.ukim.finki.wp.lab.repository.PizzaRepository;
import mk.ukim.finki.wp.lab.repository.jpa.JpaPizzaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PizzaRepositoryImpl implements PizzaRepository {

    private final JpaPizzaRepository repository;

    public PizzaRepositoryImpl(JpaPizzaRepository repository) { this.repository = repository; }

    @Override
    public Pizza save(Pizza pizza) {
        return repository.save(pizza);
    }

    @Override
    public void delete(Pizza pizza) {
        repository.delete(pizza);
    }

    @Override
    public void deleteById(String name) {
        repository.deleteById(name);
    }

    @Override
    public List<Pizza> findAll() {
        return repository.findAll();
    }

    @Override
    public Pizza findById(String id) {
        return repository.findById(id).orElseThrow(PizzaNotFound::new);
    }

    @Override
    public List<Pizza> findPizzasByIngredientsLessThan(int ingredientsNumber) {
        return repository.findAllByIngredientsIsLessThan(ingredientsNumber);
    }

    @Override
    public List<Pizza> getPizzasWithIngredient(long id) {
        return repository.findByIngredients_Id(id);
    }
}
