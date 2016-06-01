package foamenbot.services;

import foamenbot.model.Order;
import foamenbot.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


@Service
public class OrderServiceImpl implements  OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void save(Order order){ orderRepository.save(order);}
    @Override
    public void delete(Order order){ orderRepository.delete(order);}

    @Override
    public Order findByName(String name) {
        return orderRepository.findByName(name);
    }

    @Override
    public Set<Order> findByStatus(String status){ return orderRepository.findByStatus(status);}
    @Override
    public Order findById(long id){ return orderRepository.findById(id);}
    @Override
    public Set<Order> findAll(){ return orderRepository.findAll(); }
}
