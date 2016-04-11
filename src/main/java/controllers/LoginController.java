package controllers;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import services.UserService;

import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @ModelAttribute("allUsers")
    private List<User> getAllUsers() {
        return userService.findAll();
    }


    @RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
    public String getLoginPage() {
        return "login";
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    public String login(Model model) {
        return "redirect: /home";
    }

    @RequestMapping(value = {"/home"}, method = RequestMethod.GET)
    public String getHomePage() {
        return "home";
    }

}
