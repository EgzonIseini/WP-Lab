package mk.ukim.finki.wp.lab.repository.jpa;

import mk.ukim.finki.wp.lab.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaIngredientRepository extends JpaRepository<Ingredient, Long> {

    List<Ingredient> findAllBySpicyTrue();

    boolean existsByName(String name);

    long countAllBySpicyTrue();

}
