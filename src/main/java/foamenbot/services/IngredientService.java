package foamenbot.services;

import foamenbot.model.Ingredient;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface IngredientService {
    List<Ingredient> findAll();
    Ingredient findByName(String name);
    Ingredient findById(long id);
    void save(Ingredient ingredient);
    void delete(Ingredient ingredient);

    int doPostAndReturnHTTPStatus(String ingredientName, int quantity);
}
