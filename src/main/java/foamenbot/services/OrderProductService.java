package foamenbot.services;

import foamenbot.model.Order;
import foamenbot.model.OrderProduct;
import foamenbot.model.Product;

import java.util.Set;

public interface OrderProductService {

    OrderProduct findById(long id);
    OrderProduct findByProductAndOrder(Product product, Order order);
    void save(Set<OrderProduct> orderProducts);
    void save(OrderProduct orderProduct);
    void delete(Set<OrderProduct> orderProducts);
    void delete(OrderProduct orderProduct);
}
