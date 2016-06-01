package foamenbot.repositories;

import foamenbot.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface OrderRepository extends CrudRepository<Order,Long> {

    Set<Order> findByStatus(String status);
    Set<Order> findByDate(String date);
    Set<Order> findAll();
    Order findByName(String name);
    Order findById(long id);
}
