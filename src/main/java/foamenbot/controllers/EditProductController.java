package foamenbot.controllers;


import foamenbot.model.Category;
import foamenbot.model.Ingredient;
import foamenbot.model.Product;
import foamenbot.model.ProductIngredient;
import foamenbot.services.CategoryService;
import foamenbot.services.IngredientService;
import foamenbot.services.ProductIngredientService;
import foamenbot.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Controller
public class EditProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private IngredientService ingredientService;

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
        ProductIngredient ingredient = new ProductIngredient();
        List<ProductIngredient> productIngredients = product.getIngredientList();
        model.addAttribute("productIngredients", productIngredients);
        model.addAttribute("product", product);
        model.addAttribute("ingredient",ingredient);
        return "editProduct";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String editCurrentProduct(Product product, Model model) {
        productService.save(product);
        return "redirect:/edit/" + product.getId();
    }

    @RequestMapping(value = "/editingredients/{id}", method = RequestMethod.POST)
    public String addIngredientsToProduct(@PathVariable long id, ProductIngredient ingredient, Model model){
        ingredient.setProduct(productService.findById(id));
        ingredient.setId(0);
        if(ingredientService.findByName(ingredient.getProductName()) != null) {
            ingredient.setIngredient(ingredientService.findByName(ingredient.getProductName()));
        }
        else{
            Ingredient newIngredient = new Ingredient();
            newIngredient.setName(ingredient.getProductName());
            newIngredient.setQuantity(0);
            newIngredient.setQuantityType("kg");
            ingredientService.save(newIngredient);
            ingredient.setIngredient(newIngredient);
        }
       productIngredientService.save(ingredient);
        return "redirect:/edit/" + id;
    }
}
