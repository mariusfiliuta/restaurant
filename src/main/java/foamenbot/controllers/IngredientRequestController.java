package foamenbot.controllers;

import foamenbot.model.Ingredient;
import foamenbot.model.User;
import foamenbot.services.IngredientService;
import foamenbot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IngredientRequestController {

    private static final int EXPECTATION_FAILED = 417;
    private static final int ACCEPTED = 202;
    private static final int BAD_REQUEST = 400;

    @Autowired
    private IngredientService ingredientService;

    @Autowired
    private UserService userService;

    @ModelAttribute("currentUser")
    private User getCurrentUser() {
        return userService.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName()).get(0);
    }

    @ModelAttribute("ingredientsWithLowQuantity")
    private List<Ingredient> getIngredientsWithLowQuantity() {
        List<Ingredient> allIngredient = ingredientService.findAll();
        List<Ingredient> ingredientsWithLowQuantity = new ArrayList<>();
        for (Ingredient ingredient : allIngredient) {
            if (ingredient.getQuantity() < 5)
                ingredientsWithLowQuantity.add(ingredient);
        }
        return ingredientsWithLowQuantity;
    }

    @RequestMapping(value = {"/requestIngredients"}, method = RequestMethod.GET)
    public String getRequestIngredientsPage() {
        return "request-ingredients";
    }

    @RequestMapping(value = {"/requestIngredients/{ingredientName}/{quantity}"}, method = RequestMethod.POST)
    public String requestIngredients(Model model, @PathVariable String ingredientName, @PathVariable int quantity) {
        int httpStatus = ingredientService.doPostAndReturnHTTPStatus(ingredientName, quantity);
        if (httpStatus == ACCEPTED) {
            Ingredient ingredient = ingredientService.findByName(ingredientName);
            ingredient.setQuantity(ingredient.getQuantity() + quantity);
            ingredientService.save(ingredient);
            return "redirect:/requestIngredients?accepted=true";
        }
        else if(httpStatus == EXPECTATION_FAILED) {
            return "redirect:/requestIngredients?expectation_failed=true";
        }
        else {
            return "redirect:/requestIngredients?bad_request=true";
        }
    }

}
