package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.model.Ingredient;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IngredientRepository {

    Ingredient save(Ingredient ingredient);

    Ingredient update(Ingredient ingredient);

    Page<Ingredient> findAll(int page, int size);

    List<Ingredient> findAllSpicy();

    Ingredient find(long id);

    void delete(long id);
}
