package foamenbot.repositories;

import foamenbot.model.History;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface HistoryRepository extends CrudRepository<History,Long>{

    Set<History> findAll();
    History findById(long id);
    Set<History> findByStartDateContaining(String date);
}
