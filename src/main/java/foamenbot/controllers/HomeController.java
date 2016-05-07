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

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/home"}, method = RequestMethod.GET)
    public String getHomePage() {
        return "home";
    }

    @RequestMapping(value = {"/createAdmin"}, method = RequestMethod.GET)
    public String getCreateAdminPage(Model model) {
        User user = new User();
        user.setRole("ADMIN");
        model.addAttribute("user", user);
        return "createAdmin";
    }

    @RequestMapping(value = {"/createAdmin"}, method = RequestMethod.POST)
    public String createAdmin(Model model, @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("user", user);
            return "createAdmin";
        }
        user.setRole("ADMIN");

        String encodedPass = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPass);

        userService.save(user);

        return "redirect:/login";
    }

}
