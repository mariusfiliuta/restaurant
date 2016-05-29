package foamenbot.controllers;

import foamenbot.model.Category;
import foamenbot.model.Product;
import foamenbot.model.ProductIngredient;
import foamenbot.model.User;
import foamenbot.repositories.ProductRepository;
import foamenbot.services.ProductService;
import foamenbot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import foamenbot.services.CategoryService;

import java.util.List;

@Controller
public class CategoriesController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @ModelAttribute("currentUser")
    private User getCurrentUser() {
        return userService.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName()).get(0);
    }

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

    @RequestMapping(value = {"/categories/{id}"}, method = RequestMethod.GET)
    public String getProductsForEachCategory(@PathVariable long id, Model model) {
        Category currentCategory = categoryService.findById(id);
        List<Product> products = productService.findByCategory(currentCategory);
        model.addAttribute("category", currentCategory);
        model.addAttribute("products", products);
        return "productsView";
    }
}
