package foamenbot.controllers;

import foamenbot.model.Mese;
import foamenbot.model.Reservation;
import foamenbot.model.User;
import foamenbot.services.MeseService;
import foamenbot.services.ReservationService;
import foamenbot.services.UserService;
import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Set;

/**
 * Created by Mihai on 01.06.2016.
 */
@Controller
public class BookingController {
    @Autowired
    private UserService userService;

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private MeseService meseService;

    @ModelAttribute("mese")
    private Set<Mese> getAllTables(){
        Set<Mese> allTables = meseService.findAll();
        return allTables;
    }

    @ModelAttribute("reservation")
    public Reservation getReservationForCreate(){
        Reservation myReservation = new Reservation();
        return  myReservation;
    }

    @ModelAttribute("currentUser")
    private User getCurrentUser() {
        return userService.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName()).get(0);
    }

    @ModelAttribute("reservations")
    public Set<Reservation> getAllReservations(){
        return reservationService.findAll();
    }

    @RequestMapping(value="/booking", method = RequestMethod.GET)
    public String getBookingPage(Model model){
        return "booking";
    }

    @RequestMapping(value="/createBooking", method = RequestMethod.POST)
    public String createBooking(Reservation reservation, Model model){
        reservation.setMasa(meseService.findByName(reservation.getTableName()));
        reservationService.save(reservation);
        return "redirect:/booking";
    }

    @RequestMapping(value="/deleteBooking/{id}", method=RequestMethod.POST)
    public String deleteBooking(@PathVariable long id, Model model){
        reservationService.delete(reservationService.findById(id));
        return "redirect:/booking";
    }
}
