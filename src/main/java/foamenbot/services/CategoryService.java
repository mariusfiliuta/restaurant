package foamenbot.services;

import foamenbot.model.Category;
import java.util.List;

public interface CategoryService {

    List<Category> findAll();
    Category findByCategoryName(String categoryName);
    void delete(Category category);
    void save(Category category);
}
