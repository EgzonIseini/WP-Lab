package mk.ukim.finki.wp.lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Ingredients")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private boolean spicy;

    private float amount;

    private boolean veggie;

    public Ingredient(String name, boolean spicy, float amount, boolean veggie) {
        this.name = name;
        this.spicy = spicy;
        this.amount = amount;
        this.veggie = veggie;
    }
}
