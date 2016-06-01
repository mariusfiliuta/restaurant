package foamenbot.repositories;

import foamenbot.model.Category;
import foamenbot.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{

    List<Product> findAll();
    Product findById(long id);
    Set<Product> findByProductNameContaining(String name);
    List<Product> findByCategory(Category category);
}
