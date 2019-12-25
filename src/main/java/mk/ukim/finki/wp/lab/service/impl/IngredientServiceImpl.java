package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Ingredient;
import mk.ukim.finki.wp.lab.model.Pizza;
import mk.ukim.finki.wp.lab.model.exceptions.IngredientAlreadyExists;
import mk.ukim.finki.wp.lab.model.exceptions.IngredientNotFound;
import mk.ukim.finki.wp.lab.model.exceptions.TooManySpicyIngredients;
import mk.ukim.finki.wp.lab.repository.IngredientRepository;
import mk.ukim.finki.wp.lab.service.IngredientService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository repository;

    public IngredientServiceImpl(IngredientRepository repository) {
        this.repository = repository;
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        if(ingredient.isSpicy() && repository.countAllBySpicyTrue() >= 3) throw new TooManySpicyIngredients();
        else if(repository.existsByName(ingredient.getName())) throw new IngredientAlreadyExists();
        else return repository.save(ingredient);
    }

    @Override
    public Ingredient update(long id, String name, Boolean spicy, Float amount, Boolean veggie) {
        Ingredient ingredient = this.find(id);

        if(name != null) ingredient.setName(name);
        if(spicy != null) ingredient.setSpicy(spicy);
        if(amount != null) ingredient.setAmount(amount);
        if(veggie != null) ingredient.setVeggie(veggie);

        return repository.save(ingredient);
    }

    @Override
    public Ingredient find(long id) {
        return repository.findById(id).orElseThrow(IngredientNotFound::new);
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }

    @Override
    public Page<Ingredient> getAllPaged(int page, int size) {
        return repository.findAll(PageRequest.of(page, size, Sort.by("name")));
    }

    @Override
    public List<Ingredient> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Ingredient> findAllSpicy(boolean spicy) {
        return repository.findAllBySpicyEquals(spicy);
    }

    @Override
    public List<Ingredient> comparePizzas(Pizza pizza1, Pizza pizza2) {
        return pizza1.getIngredients()
                .stream()
                .filter(pizza2.getIngredients()::contains)
                .collect(Collectors.toList());
    }
}
