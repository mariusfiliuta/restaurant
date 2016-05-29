package foamenbot.controllers;

import foamenbot.model.Category;
import foamenbot.model.User;
import foamenbot.services.ProductIngredientService;
import foamenbot.services.ProductService;
import foamenbot.services.CategoryService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import foamenbot.model.Product;
import foamenbot.model.ProductIngredient;
import foamenbot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.naming.Binding;
import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@Controller

public class AddProductController {

    @Autowired
    private UserService userService;

    @ModelAttribute("currentUser")
    private User getCurrentUser() {
        return userService.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName()).get(0);
    }

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("categories")
    public List<Category> getCategories() {
        return categoryService.findAll();
    }

    @RequestMapping(value = {"/addProduct"}, method = RequestMethod.GET)
    public String getAddProductPage(Model model) {
        Product product = new Product();
        Set<ProductIngredient> ingredientSet;
        model.addAttribute("product", product);
        return "addProduct";
    }

    @RequestMapping(value = {"/addProduct"}, method = RequestMethod.POST)
    public String addProduct(Model model, @Valid Product product, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            model.addAttribute("product", product);
            return "addProduct";
        }
        product.setIn_stock("N");
        productService.save(product);
        return "redirect:/addProduct";
    }
}
