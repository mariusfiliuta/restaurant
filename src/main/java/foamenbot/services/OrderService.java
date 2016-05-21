package foamenbot.services;

import foamenbot.model.Order;

import java.util.List;


public interface OrderService {

    Order findById(long id);
    void save(Order order);
    void delete(Order order);
    List<Order> findByStatus(String status);
}
