package foamenbot.repositories;

import foamenbot.model.HistoryProduct;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryProductRepository extends CrudRepository<HistoryProduct, Long>{
    HistoryProduct findById(long id);
}
