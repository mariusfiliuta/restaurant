package foamenbot.services;

import foamenbot.model.OrderProduct;

import java.util.Set;

public interface OrderProductService {

    OrderProduct findById(long id);
    void save(Set<OrderProduct> orderProducts);
    void save(OrderProduct orderProduct);
    void delete(Set<OrderProduct> orderProducts);
    void delete(OrderProduct orderProduct);
}
