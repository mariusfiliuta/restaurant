package foamenbot.controllers;

import foamenbot.config.CustomAuthenticationProvider;
import foamenbot.model.User;
import foamenbot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class HomeController {

    @RequestMapping(value = {"/home"}, method = RequestMethod.GET)
    public String getHomePage() {
        return "home";
    }

}
