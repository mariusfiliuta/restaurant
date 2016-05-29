package foamenbot.repositories;

import foamenbot.model.Category;
import foamenbot.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{

    List<Product> findAll();
    Product findById(long id);
    List<Product> findByCategory(Category category);
}
