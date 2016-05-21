package foamenbot.controllers;

import foamenbot.model.Category;
import foamenbot.model.Ingredient;
import foamenbot.model.Product;
import foamenbot.model.ProductIngredient;
import foamenbot.services.CategoryService;
import foamenbot.services.IngredientService;
import foamenbot.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

/**
 * Created by Mihai on 21.05.2016.
 */

@Controller

public class AddIngredientController {
    @Autowired
    private IngredientService ingredientService;



    @RequestMapping(value = {"/addIngredient"}, method = RequestMethod.GET)
    public String getAddIngredientPage(Model model) {
        Ingredient ingredient = new Ingredient();
        model.addAttribute("ingredient", ingredient);
        return "addIngredient";
    }

    @RequestMapping(value = {"/addIngredient"}, method = RequestMethod.POST)
    public String addIngredient(Model model, @Valid Ingredient ingredient, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            model.addAttribute("ingredient", ingredient);
            return "addIngredient";
        }
        ingredientService.save(ingredient);
        return "redirect:/addIngredient";
    }
}
