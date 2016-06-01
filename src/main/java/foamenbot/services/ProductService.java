package foamenbot.services;

import foamenbot.model.Category;
import foamenbot.model.Product;

import java.util.List;
import java.util.Set;

public interface ProductService {

    List<Product> findAll();
    void save(Product product);
    void delete(Product product);
    Product findById(long id);
    Set<Product> findByName(String name);
    List<Product> findByCategory(Category category);
    boolean isInStock(Product product);
    void deleteFromStock(Product product);
}
