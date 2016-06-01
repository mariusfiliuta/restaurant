package foamenbot.services;

import foamenbot.model.Reservation;

import java.util.Set;

public interface ReservationService {
    Set<Reservation> findAll();
    Set<Reservation> findByDay(String date);
    Reservation findById(long id);
    void save(Reservation reservation);
    void delete(Reservation reservation);
}
