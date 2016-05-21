package foamenbot.services;

import foamenbot.model.ProductIngredient;

import java.util.Set;

public interface ProductIngredientService {
    void save(Set<ProductIngredient> productIngredients);
    void save(ProductIngredient productIngredient);
    void delete(Set<ProductIngredient> productIngredients);
    void delete(ProductIngredient productIngredient);
    ProductIngredient findById(long id);
}
