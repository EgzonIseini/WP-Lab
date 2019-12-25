package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    long countAllBySpicyTrue();

    boolean existsByName(String name);

    List<Ingredient> findAllBySpicyEquals(boolean equals);

}
