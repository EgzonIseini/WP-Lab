package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PizzaRepository extends JpaRepository<Pizza, String> {

    List<Pizza> findByIngredients_Id(long id);

    @Query("select p from Pizza p where size(p.ingredients) < :term")
    List<Pizza> findAllByIngredientsIsLessThan(@Param("term") int less);
}
