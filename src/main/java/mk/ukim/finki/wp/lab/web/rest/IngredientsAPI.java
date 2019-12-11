package mk.ukim.finki.wp.lab.web.rest;

import mk.ukim.finki.wp.lab.model.Ingredient;
import mk.ukim.finki.wp.lab.model.Pizza;
import mk.ukim.finki.wp.lab.service.IngredientService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/ingredients", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
public class IngredientsAPI {

    private final IngredientService service;

    public IngredientsAPI(IngredientService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Ingredient createIngredient(@RequestParam("name") String name,
                                       @RequestParam("spicy") boolean spicy,
                                       @RequestParam("amount") float amount,
                                       @RequestParam("veggie") boolean veggie) {

        return service.save(new Ingredient(name, spicy, amount, veggie));
    }

    @PatchMapping("/{id}")
    public Ingredient modifyIngredient(@PathVariable long id,
                                       @RequestParam(value = "name", required = false) String name,
                                       @RequestParam(value = "spicy", required = false) Boolean spicy,
                                       @RequestParam(value = "amount", required = false) Float amount,
                                       @RequestParam(value = "veggie", required = false) Boolean veggie) {

        return service.update(id, name, spicy, amount, veggie);
    }

    @DeleteMapping("/{id}")
    public void deleteIngredient(@PathVariable long id) {
        service.delete(id);
    }

    @GetMapping
    public Page<Ingredient> getAllIngredients(@RequestParam(value = "page", defaultValue = "0", required = false) int page,
                                              @RequestParam(value = "size", defaultValue = "5", required = false) int size) {

        return service.getAllPaged(page, size);
    }

    @GetMapping(params = "spicy")
    public List<Ingredient> getAllSpicyIngredients(@RequestParam(value = "spicy") boolean spicy) {
        return service.findAllSpicy();
    }

    @GetMapping("/{id}")
    public Ingredient getIngredient(@PathVariable long id) {
        return service.find(id);
    }

    @GetMapping("/{id}/pizzas")
    public List<Pizza> getPizzasWithIngredient(@PathVariable long id) {
        return service.findPizzasWithIngredientId(id);
    }

}
