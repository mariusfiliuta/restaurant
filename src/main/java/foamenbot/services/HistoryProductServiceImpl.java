package foamenbot.services;

import foamenbot.model.HistoryProduct;
import foamenbot.repositories.HistoryProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class HistoryProductServiceImpl implements HistoryProductService{

    @Autowired
    private HistoryProductRepository historyProductRepository;

    @Override
    public HistoryProduct findById(long id) {
        return historyProductRepository.findById(id);
    }

    @Override
    public void save(HistoryProduct historyProduct) {
        historyProductRepository.save(historyProduct);
    }

    @Override
    public void save(Set<HistoryProduct> historyProduct) {
        historyProductRepository.save(historyProduct);
    }
}
