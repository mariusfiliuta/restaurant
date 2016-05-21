package foamenbot.services;

import foamenbot.model.Ingredient;
import foamenbot.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientServiceImpl implements  IngredientService{

    @Autowired
    private IngredientRepository ingredientRepository;

    @Override
    public List<Ingredient> findAll(){ return ingredientRepository.findAll();}
    @Override
    public Ingredient findByName(String name){ return ingredientRepository.findByName(name);}
    @Override
    public void save(Ingredient ingredient){ ingredientRepository.save(ingredient);}
    @Override
    public void delete(Ingredient ingredient){ ingredientRepository.delete(ingredient);}
    @Override
    public Ingredient findById(long id){ return ingredientRepository.findById(id);}

}
