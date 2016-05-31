package foamenbot.controllers;

import foamenbot.model.Order;
import foamenbot.model.OrderProduct;
import foamenbot.model.User;
import foamenbot.services.OrderProductService;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Mihai on 31.05.2016.
 */
@Controller
public class OrderDetailsController {
    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderProductService orderProductService;

    @ModelAttribute("currentUser")
    private User getCurrentUser() {
        return userService.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName()).get(0);
    }

    @RequestMapping(value = {"/order/details/{id}"}, method = RequestMethod.GET)
    public String getOrderDetails(@PathVariable long id, Model model) {
            Order order = orderService.findById(id);
        List<OrderProduct> orderProducts = new ArrayList<OrderProduct>(order.getOrderProduct());
        model.addAttribute("order",order);
        model.addAttribute("orderProducts",orderProducts);
        return "orderDetails";
    }

    @RequestMapping(value = {"/deleteOrderProduct/{id}/{orderProductID}"}, method = RequestMethod.POST)
    public String deleteOrderProduct(@PathVariable long id, @PathVariable long orderProductID, Model model){
        Order myOrder = orderService.findById(id);
        myOrder.setTotalPrice(myOrder.getTotalPrice() - orderProductService.findById(orderProductID).getProduct().getPrice());
        orderProductService.delete(orderProductService.findById(orderProductID));
        return "redirect:/order/details/" + id;
    }

    @RequestMapping(value = {"/finishOrder/{orderId}"}, method = RequestMethod.POST)
    public String finishOrder(@PathVariable long orderId, Model model){

        return "redirect:/addOrder";
    }
}
