package foamenbot.services;

import foamenbot.model.Mese;

import java.util.Set;

public interface MeseService {
    Set<Mese> findAll();
    void save(Mese masa);
    void delete(Mese masa);
}
