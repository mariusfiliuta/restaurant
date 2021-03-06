package foamenbot.services;

import foamenbot.model.Order;
import foamenbot.model.OrderProduct;
import foamenbot.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import foamenbot.repositories.OrderProductRepository;

import java.util.Set;

@Service
public class OrderProductServiceImpl implements OrderProductService{

    @Autowired
    private OrderProductRepository orderProductRepository;

    @Override
    public void save(Set<OrderProduct> orderProducts){ orderProductRepository.save(orderProducts);}
    @Override
    public void save(OrderProduct orderProduct){ orderProductRepository.save(orderProduct);}
    @Override
    public void delete(Set<OrderProduct> orderProducts){ orderProductRepository.delete(orderProducts);}
    @Override
    public void delete(OrderProduct orderProduct){ orderProductRepository.delete(orderProduct);}
    @Override
    public OrderProduct findById(long id){ return orderProductRepository.findById(id);}

    @Override
    public OrderProduct findByProductAndOrder(Product product, Order order) {
        return orderProductRepository.findByProductAndOrder(product, order);
    }
}
