package foamenbot.controllers;

import foamenbot.model.*;
import foamenbot.services.CategoryService;
import foamenbot.services.IngredientService;
import foamenbot.services.ProductService;
import foamenbot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@Controller
public class AddIngredientController {

    @Autowired
    private UserService userService;

    @ModelAttribute("currentUser")
    private User getCurrentUser() {
        return userService.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName()).get(0);
    }

    @Autowired
    private IngredientService ingredientService;

    @RequestMapping(value = {"/addIngredient"}, method = RequestMethod.GET)
    public String getAddIngredientPage(Model model) {
        Ingredient ingredient = new Ingredient();
        model.addAttribute("ingredient", ingredient);
        return "addIngredient";
    }d

    @RequestMapping(value = {"/addIngredient"}, method = RequestMethod.POST)
    public String addIngredient(Model model, @Valid Ingredient ingredient, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            model.addAttribute("ingredient", ingredient);
            return "addIngredient";
        }
        if(ingredientService.findByName(ingredient.getName())!= null){
            ingredient.setId(ingredientService.findByName(ingredient.getName()).getId());
        }
        ingredientService.save(ingredient);
        return "redirect:/addIngredient";
    }
}
