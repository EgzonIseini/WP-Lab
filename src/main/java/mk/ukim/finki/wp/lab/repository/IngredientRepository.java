package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    long countAllBySpicyTrue();

    boolean existsByName(String name);

    List<Ingredient> findAllBySpicyEquals(boolean equals);

}
