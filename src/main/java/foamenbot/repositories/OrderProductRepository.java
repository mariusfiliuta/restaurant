package foamenbot.repositories;

import foamenbot.model.OrderProduct;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderProductRepository extends CrudRepository<OrderProduct,Long>{
    OrderProduct findById(int id);
}
