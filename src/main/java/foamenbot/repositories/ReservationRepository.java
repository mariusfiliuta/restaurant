package foamenbot.repositories;

import foamenbot.model.Mese;
import foamenbot.model.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long>{
    Set<Reservation> findAll();
    Set<Reservation> findByStartDateContaining(String startDate);
}
