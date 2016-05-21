package foamenbot.services;

import foamenbot.model.Order;

import java.util.List;


public interface OrderService {

    Order findById(int id);
    void save(Order order);
    void delete(Order order);
    List<Order> findByStatus(String status);
}
