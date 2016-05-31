package foamenbot.repositories;

import foamenbot.model.Mese;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface MeseRepository extends CrudRepository<Mese, Long>{
    Set<Mese> findAll();
}
