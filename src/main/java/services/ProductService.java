package services;

import model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {

    List<Product> findAll();
    void save(Product product);
    void delete(Product product);
}
