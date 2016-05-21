package foamenbot.repositories;

import foamenbot.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{

    public List<Product> findAll();
    public Product findById(long id);
}
