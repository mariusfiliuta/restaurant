package foamenbot.repositories;


import foamenbot.model.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
    List<Ingredient> findAll();
    Ingredient findByName(String name);
    Ingredient findById(int id);
}
