package foamenbot.services;

import foamenbot.model.History;
import foamenbot.repositories.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Set;

@Service
public class HistoryServiceImpl implements HistoryService {

    @Autowired
    private HistoryRepository historyRepository;

    @Override
    public Set<History> findAll() {
        return historyRepository.findAll();
    }

    @Override
    public History findById(long id) {
        return historyRepository.findById(id);
    }

    @Override
    public Set<History> findByDay(String date) {
        return historyRepository.findByStartDateContaining(date);
    }

    @Override
    public void save(History history) {
        historyRepository.save(history);
    }

    @Override
    public void delete(History history) {
        historyRepository.delete(history);
    }
}
