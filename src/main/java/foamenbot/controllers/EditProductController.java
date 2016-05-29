package foamenbot.controllers;


import foamenbot.model.Category;
import foamenbot.model.Ingredient;
import foamenbot.model.Product;
import foamenbot.model.ProductIngredient;
import foamenbot.services.CategoryService;
import foamenbot.services.ProductIngredientService;
import foamenbot.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class EditProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductIngredientService productIngredientService;

    @ModelAttribute("categories")
    public List<Category> getCategories() {
        return categoryService.findAll();
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String getEditableProduct(@PathVariable long id, Model model) {
        Product product = productService.findById(id);
        List<ProductIngredient> productIngredients = product.getIngredientList();
        model.addAttribute("productIngredients", productIngredients);
        model.addAttribute("product", product);
        return "editProduct";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String editCurrentProduct(Product product, Model model) {
        productService.save(product);
        return "redirect:/edit/" + product.getId();
    }

}