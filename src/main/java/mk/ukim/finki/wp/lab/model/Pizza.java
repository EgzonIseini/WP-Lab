package mk.ukim.finki.wp.lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Pizza {

    public Pizza(String name) {
        this.name = name;
        this.description = "";
        this.ingredients = new ArrayList<>();
    }

    public Pizza(String name, String description, boolean veggie) {
        this.name = name;
        this.description = description;
        this.veggie = veggie;
        this.ingredients = new ArrayList<>();
    }

    @Id
    private String name;

    private String description;

    @ManyToMany(cascade = CascadeType.REMOVE)
    private List<Ingredient> ingredients;

    private boolean veggie;

}
