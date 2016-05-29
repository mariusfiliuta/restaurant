package foamenbot.repositories;

import foamenbot.model.Order;
import foamenbot.model.OrderProduct;
import foamenbot.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderProductRepository extends CrudRepository<OrderProduct,Long>{
    OrderProduct findById(long id);
    OrderProduct findByProductAndOrder(Product product, Order order);
}
