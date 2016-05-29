package foamenbot.controllers;

import foamenbot.model.Ingredient;
import foamenbot.model.Order;
import foamenbot.model.User;
import foamenbot.services.OrderService;
import foamenbot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @ModelAttribute("currentUser")
    private User getCurrentUser() {
        return userService.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName()).get(0);
    }

    @ModelAttribute("orders")
    private List<Order> getAllOrders() {
        return orderService.findByStatus("active");
    }

    @RequestMapping(value = {"/addOrder"}, method = RequestMethod.GET)
    public String getAddOrderPage(Model model) {
        Order order = new Order();
        model.addAttribute("order", order);
        return "createOrder";
    }

    @RequestMapping(value = {"/addOrder"}, method = RequestMethod.POST)
    public String createOrder(Order order, Model model) {
        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Calendar calendarInstance = Calendar.getInstance();
        order.setDate(df.format(calendarInstance.getTime()));
        order.setStatus("active");
        order.setUser(this.getCurrentUser());
        orderService.save(order);
        return "redirect:/addOrder";
    }

}
