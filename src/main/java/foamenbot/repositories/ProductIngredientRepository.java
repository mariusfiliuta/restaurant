package foamenbot.repositories;

import foamenbot.model.ProductIngredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductIngredientRepository extends CrudRepository<ProductIngredient,Long>{
    ProductIngredient findById(long id);
}
