package foamenbot.services;

import foamenbot.model.Mese;

import java.util.Set;

public interface MeseService {
    Set<Mese> findAll();
    Set<Mese> findByStatus(String status);
    Mese findByName(String name);
    Mese findById(long id);
    void save(Mese masa);
    void delete(Mese masa);
}
