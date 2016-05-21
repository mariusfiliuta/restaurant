package foamenbot.repositories;

import foamenbot.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order,Long> {

    List<Order> findByStatus(String status);
    List<Order> findByDate(String date);
    Order findById(int id);
}
