package foamenbot.controllers;

import foamenbot.model.Category;
import foamenbot.model.Product;
import foamenbot.model.ProductIngredient;
import foamenbot.repositories.ProductRepository;
import foamenbot.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import foamenbot.services.CategoryService;

import java.util.List;

@Controller
public class CategoriesController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productRepository;

    @ModelAttribute("categories")
    private List<Category> getContacts() {
        return categoryService.findAll();
    }

    @RequestMapping(value = {"/categories"}, method = RequestMethod.GET)
    public String getCategoriesPage() {
        return "categories";
    }
}
