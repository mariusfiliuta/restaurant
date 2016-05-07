package foamenbot.services;

import foamenbot.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import foamenbot.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll(){ return productRepository.findAll();}
    @Override
    public void save(Product product){ productRepository.save(product);}
    @Override
    public void delete(Product product){ productRepository.delete(product);}

}
