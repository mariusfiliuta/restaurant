package repositories;

import model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>{

    public List<Category> findAll();
    public Category findByCategoryName(String categoryName);

}
