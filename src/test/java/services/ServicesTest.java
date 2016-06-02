package services;

import foamenbot.main.App;
import foamenbot.model.Category;
import foamenbot.repositories.CategoryRepository;
import foamenbot.services.CategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.inject.Inject;
import java.util.List;

import static org.junit.Assert.assertEquals;

@ContextConfiguration(classes = App.class)
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class ServicesTest {

    @Inject
    private CategoryRepository categoryService;

    @Test
    public void shouldReturnCategories() {
        List<Category> categoriesList = categoryService.findAll();
        System.out.println("PATRU" + categoriesList.size());
    }

}
