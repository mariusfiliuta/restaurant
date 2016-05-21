package foamenbot.services;

import foamenbot.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();
    void save(Product product);
    void delete(Product product);
    Product findById(int id);
}
