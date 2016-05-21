package foamenbot.services;

import foamenbot.model.ProductIngredient;
import foamenbot.repositories.ProductIngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ProductIngredientServiceImpl implements  ProductIngredientService{

    @Autowired
    private ProductIngredientRepository productIngredientRepository;

    @Override
    public void save(Set<ProductIngredient> productIngredients){ productIngredientRepository.save(productIngredients);}
    @Override
    public void save(ProductIngredient productIngredient){ productIngredientRepository.save(productIngredient);}
    @Override
    public void delete(ProductIngredient productIngredient){ productIngredientRepository.delete(productIngredient);}
    @Override
    public void delete(Set<ProductIngredient> productIngredients){ productIngredientRepository.delete(productIngredients);}
    @Override
    public ProductIngredient findById(int id){ return productIngredientRepository.findById(id);}
}
