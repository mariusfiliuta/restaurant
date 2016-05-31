package foamenbot.services;

import foamenbot.model.History;

import java.util.Set;

public interface HistoryService {

    Set<History> findAll();
    History findById(long id);
    Set<History> findByDay(String date);
    void save(History history);
    void delete(History history);
}
