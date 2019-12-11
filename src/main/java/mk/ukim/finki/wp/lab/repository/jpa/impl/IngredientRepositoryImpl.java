package mk.ukim.finki.wp.lab.repository.jpa.impl;

import mk.ukim.finki.wp.lab.model.Ingredient;
import mk.ukim.finki.wp.lab.model.Pizza;
import mk.ukim.finki.wp.lab.model.exceptions.IngredientAlreadyExists;
import mk.ukim.finki.wp.lab.model.exceptions.IngredientNotFound;
import mk.ukim.finki.wp.lab.model.exceptions.TooManySpicyIngredients;
import mk.ukim.finki.wp.lab.repository.IngredientRepository;
import mk.ukim.finki.wp.lab.repository.jpa.JpaIngredientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class IngredientRepositoryImpl implements IngredientRepository {

    private final JpaIngredientRepository ingredientRepository;

    public IngredientRepositoryImpl(JpaIngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        if(ingredientRepository.countAllBySpicyTrue() >= 3 && ingredient.isSpicy()) throw new TooManySpicyIngredients();
        else if(ingredientRepository.existsByName(ingredient.getName())) throw new IngredientAlreadyExists();
        else return ingredientRepository.save(ingredient);
    }

    @Override
    public Ingredient update(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    @Override
    public Page<Ingredient> findAll(int page, int size) {
        return ingredientRepository.findAll(PageRequest.of(page, size, Sort.by("name")));
    }

    @Override
    public List<Ingredient> findAllSpicy() {
        return ingredientRepository.findAllBySpicyTrue();
    }

    @Override
    public Ingredient find(long id) {
        return ingredientRepository.findById(id).orElseThrow(IngredientNotFound::new);
    }

    @Override
    public void delete(long id) {
        ingredientRepository.deleteById(id);
    }
}
