package mk.ukim.finki.wp.lab.web.rest;

import mk.ukim.finki.wp.lab.model.Ingredient;
import mk.ukim.finki.wp.lab.model.Pizza;
import mk.ukim.finki.wp.lab.service.IngredientService;
import mk.ukim.finki.wp.lab.service.PizzaService;
import org.springframework.http.HttpStatus;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "/pizzas", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
public class PizzaAPI {

    private final PizzaService service;
    private final IngredientService ingredientService;

    public PizzaAPI(PizzaService service, IngredientService ingredientService) {
        this.service = service;
        this.ingredientService = ingredientService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pizza createPizza(@RequestParam("name") String name,
                                       @RequestParam("ingredient") List<Long> ingredientIds) {

        return service.createPizza(name, ingredientIds);
    }

    @PutMapping(value = "/{id}")
    public Pizza modifyPizza(@PathVariable String id,
                             @RequestParam(value = "description", required = false) String description,
                             @RequestParam(value = "veggie", required = false) Boolean veggie,
                             @RequestParam(value = "ingredient", required = false) List<Long> ingredients) {

        return service.modifyPizza(id, description, veggie, ingredients);
    }

    @DeleteMapping(value = "/{id}")
    public void deletePizza(@PathVariable String id) {
        service.deleteById(id);
    }

    @GetMapping
    public List<Pizza> getAllPizzas() {
        return service.findAll();
    }

    @GetMapping(params = "totalIngredients")
    public List<Pizza> getAllPizzasWithIngredientsLessThan(@RequestParam(value = "totalIngredients") int ingredientNo) {
        return service.findPizzasByIngredientsLessThan(ingredientNo);
    }

    @GetMapping(value = "/{id}")
    public Pizza getPizza(@PathVariable String id) {
        return service.findById(id);
    }

    @GetMapping(value = "/compare")
    public List<Ingredient> getCommonIngredients(@RequestParam(value = "pizza1") String param1,
                                                 @RequestParam(value = "pizza2") String param2) {

        Pizza pizza1 = service.findById(param1), pizza2 = service.findById(param2);

        return ingredientService.comparePizzas(pizza1, pizza2);
    }
}
