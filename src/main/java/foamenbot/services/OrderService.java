package foamenbot.services;

import foamenbot.model.Order;

import java.util.List;
import java.util.Set;


public interface OrderService {

    Order findById(long id);
    void save(Order order);
    void delete(Order order);
    Order findByName(String name);
    Set<Order> findByStatus(String status);
    Set<Order> findAll();
}
