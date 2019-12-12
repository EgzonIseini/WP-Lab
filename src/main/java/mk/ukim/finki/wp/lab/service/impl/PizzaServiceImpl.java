package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Ingredient;
import mk.ukim.finki.wp.lab.model.Pizza;
import mk.ukim.finki.wp.lab.model.exceptions.PizzaNotFound;
import mk.ukim.finki.wp.lab.model.exceptions.VeggiePizzaException;
import mk.ukim.finki.wp.lab.repository.PizzaRepository;
import mk.ukim.finki.wp.lab.service.IngredientService;
import mk.ukim.finki.wp.lab.service.PizzaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PizzaServiceImpl implements PizzaService {

    private final PizzaRepository repository;
    private final IngredientService ingredientService;

    public PizzaServiceImpl(PizzaRepository pizzaRepository, IngredientService ingredientService) {
        this.repository = pizzaRepository;
        this.ingredientService = ingredientService;
    }

    @Override
    public Pizza createPizza(String name, List<Long> ingredients) {
        Pizza pizza = new Pizza(name);

        StringBuilder sb = new StringBuilder().append(name).append(" (");

        boolean isVeggie = true;
        for(Long id : ingredients) {
            sb.append(" ");
            Ingredient ingredient = ingredientService.find(id);

            pizza.getIngredients().add(ingredient);
            if(!ingredient.isVeggie()) isVeggie = false;

            sb.append("'").append(ingredient.getName()).append("'");
        }
        sb.append(" )");

        pizza.setDescription(sb.toString());
        pizza.setVeggie(isVeggie);

        return save(pizza);
    }

    @Override
    public Pizza modifyPizza(String id, String description, Boolean veggie, List<Long> ingredients) {
        Pizza pizza = findById(id);

        if(description != null) pizza.setDescription(description);
        if(veggie != null) {
            if(!veggie) pizza.setVeggie(veggie);
            else {
                pizza.getIngredients().forEach(ingredient -> { if(ingredient.isVeggie()) throw new VeggiePizzaException(); });
                pizza.setVeggie(veggie);
            }
        }
        if(ingredients != null) {
            List<Ingredient> ingredientList = ingredients.stream().map(ingredientService::find).collect(Collectors.toList());

            StringBuilder sb = new StringBuilder().append(pizza.getName()).append(" (");

            boolean isVeggie = true;
            for(Ingredient ingredient : ingredientList) {

                if(isVeggie) { if(!ingredient.isVeggie()) isVeggie = false; }
                sb.append(" ").append("'").append(ingredient.getName()).append("'");

            }
            sb.append(" )");

            pizza.setDescription(sb.toString());
            pizza.setIngredients(ingredientList);
            pizza.setVeggie(isVeggie);
        }

        return save(pizza);
    }

    @Override
    public Pizza save(Pizza pizza) {
        return repository.save(pizza);
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
    public List<Pizza> findPizzasWithIngredientId(long id) {
        return repository.findByIngredients_Id(id);
    }
}
