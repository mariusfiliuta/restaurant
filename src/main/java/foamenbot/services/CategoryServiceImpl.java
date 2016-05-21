package foamenbot.services;

import foamenbot.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import foamenbot.repositories.CategoryRepository;

import java.util.List;

@Service
public class CategoryServiceImpl implements  CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll(){ return categoryRepository.findAll();}
    @Override
    public Category findByCategoryName(String categoryName){ return categoryRepository.findByCategoryName(categoryName);}
    @Override
    public void delete(Category category){ categoryRepository.delete(category);}
    @Override
    public void save(Category category){ categoryRepository.save(category);}
    @Override
    public Category findById(int id){ return categoryRepository.findById(id);}

}
