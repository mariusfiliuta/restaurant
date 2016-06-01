package foamenbot.controllers;

import foamenbot.model.*;
import foamenbot.services.MeseService;
import foamenbot.services.OrderService;
import foamenbot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

@Controller
public class OrderController {

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private MeseService meseService;

    @ModelAttribute("currentUser")
    private User getCurrentUser() {
        return userService.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName()).get(0);
    }
    @ModelAttribute("mese")
    private Set<Mese> getAllTables(){
        Set<Mese> freeTables = meseService.findByStatus("liber");
        return freeTables;
    }
    @ModelAttribute("orders")
    private Set<Order> getAllOrders() {
        Set<Order> allOrders = orderService.findAll();
        allOrders.removeAll(this.getCurrentUser().getOrders());
        return allOrders;
    }

    @ModelAttribute("myOrders")
    private Set<Order> getMyOrders(){ return this.getCurrentUser().getOrders(); }

    @RequestMapping(value = {"/addOrder"}, method = RequestMethod.GET)
    public String getAddOrderPage(Model model) {
        Order order = new Order();
        model.addAttribute("order", order);
        return "createOrder";
    }

    @RequestMapping(value = {"/addOrder"}, method = RequestMethod.POST)
    public String createOrder(Order order, Model model) {
        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Mese masaComenzii = meseService.findByName(order.getName());
        masaComenzii.setStatus("ocupat");
        meseService.save(masaComenzii);
        Calendar calendarInstance = Calendar.getInstance();
        order.setDate(df.format(calendarInstance.getTime()));
        order.setStatus("active");
        order.setUser(this.getCurrentUser());
        orderService.save(order);
        return "redirect:/addOrder";
    }

}
