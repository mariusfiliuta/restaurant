package foamenbot.services;

import foamenbot.model.Reservation;
import foamenbot.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ReservationServiceImpl implements  ReservationService{
    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public Set<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    @Override
    public Set<Reservation> findByDay(String date) {
        return reservationRepository.findByStartDateContaining(date);
    }

    @Override
    public Reservation findById(long id) {
        return reservationRepository.findById(id);
    }

    @Override
    public void save(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    @Override
    public void delete(Reservation reservation) {
        reservationRepository.delete(reservation);
    }
}
