package services;

import foamenbot.main.App;
import foamenbot.model.Category;
import foamenbot.services.CategoryServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = App.class)
public class ServicesTest {

    private CategoryServiceImpl categoryService;

    @Test
    public void shouldReturnCategories() {
        List<Category> categoriesList = categoryService.findAll();
        assertEquals(categoriesList.size(), 4);
    }

}
