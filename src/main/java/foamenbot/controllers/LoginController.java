package foamenbot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import foamenbot.services.UserService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginForm(HttpServletRequest request, Model model) {
        return "login";
    }

}
