package foamenbot.services;

import foamenbot.model.Category;
import foamenbot.model.Ingredient;
import foamenbot.model.Product;
import foamenbot.model.ProductIngredient;
import foamenbot.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import foamenbot.repositories.ProductRepository;

import java.util.List;
import java.util.Set;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private IngredientRepository ingredientRepository;

    @Override
    public List<Product> findAll(){ return productRepository.findAll();}

    @Override
    public void save(Product product){ productRepository.save(product);}

    @Override
    public void delete(Product product){ productRepository.delete(product);}

    @Override
    public Product findById(long id){ return productRepository.findById(id);}

    @Override
    public Set<Product> findByName(String name) {
        return productRepository.findByProductNameContaining(name);
    }

    @Override
    public boolean isInStock(Product product){
        List<ProductIngredient> productIngredients = product.getIngredientList();
        boolean isIn = true;
        for(ProductIngredient productIngredient:productIngredients){
            long first = 0, second = 0;
            if(productIngredient.getQuantityType().equals("g"))
                first = productIngredient.getQuantity();
            else
                first = productIngredient.getQuantity()*1000;
            if(productIngredient.getIngredient().getQuantityType().equals("g"))
                second = productIngredient.getIngredient().getQuantity();
            else
                second = productIngredient.getIngredient().getQuantity()*1000;
            if(first>second){
                isIn = false;
                break;
            }
        }
        product.setIn_stock((isIn? "Y":"N"));
        productRepository.save(product);
        return isIn;
    }

    @Override
    public void deleteFromStock(Product product) {
        List<ProductIngredient> productIngredients = product.getIngredientList();
        for(ProductIngredient productIngredient:productIngredients) {
            Ingredient ingredient = productIngredient.getIngredient();
            if(productIngredient.getQuantityType().equals(ingredient.getQuantityType())){
                ingredient.setQuantity(ingredient.getQuantity()-productIngredient.getQuantity());
            }
            else{
                ingredient.setQuantity((ingredient.getQuantity()*1000 - productIngredient.getQuantity())/1000);
            }
            ingredientRepository.save(ingredient);
        }
    }

    @Override
    public List<Product> findByCategory(Category category) {
        return productRepository.findByCategory(category);
    }

}
