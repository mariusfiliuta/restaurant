package foamenbot.controllers;

import foamenbot.model.*;
import foamenbot.services.*;
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
import java.util.Set;

/**
 * Created by Mihai on 01.06.2016.
*/
@Controller
public class HistoryController {
    @Autowired
    private UserService userService;

    @Autowired
    private HistoryService historyService;

    @ModelAttribute("currentUser")
    private User getCurrentUser() {
        return userService.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName()).get(0);
    }
    @ModelAttribute("search")
    private helpObject getHelpObject(){
        helpObject searchObject = new helpObject();
        return searchObject;
    }
    @ModelAttribute("history")
    private Set<History> getHistory() {
        return historyService.findAll();
    }

    @RequestMapping(value = {"/history"}, method = RequestMethod.GET)
    public String getHistory(Model model) {
        return "history";
    }
    //http://localhost:8080     /history/search?id=&waiter=wait&day=
    @RequestMapping(value = {"/history/search/{searchId}/{searchWaiter}/{searchDay}"}, method = RequestMethod.GET)
    public String getHistorySearch(@PathVariable long searchId, @PathVariable String searchWaiter, @PathVariable String searchDay, Model model){
        return "searchedHistoryPage";
    }
}

