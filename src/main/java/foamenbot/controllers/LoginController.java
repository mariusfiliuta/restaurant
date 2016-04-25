package foamenbot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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
//        foamenbot.model.addAttribute("currentUser", new User());
        return "login";
    }
//
//    @Bean
//    public UsernamePasswordAuthenticationFilter usernamePasswordAuthenticationFilter() throws Exception {
//        UsernamePasswordAuthenticationFilter upaFilter = new UsernamePasswordAuthenticationFilter();
//        upaFilter.setAuthenticationManager(authenticationManagerBean());
//
//        AuthenticationFailureService authenticationFailureService = new AuthenticationFailureService();
//        authenticationFailureService.setBadCredentialsUrl("/login?badcred=1");
//        authenticationFailureService.setDefaultFailureUrl("/login?error=1");
//
//        upaFilter.setAuthenticationFailureHandler(authenticationFailureService);
//
//        return upaFilter;
//    }
//
//    @Bean
//    SecurityContextPersistenceFilter securityContextPersistenceFilter() {
//        return new SecurityContextPersistenceFilter();
//    }
}
