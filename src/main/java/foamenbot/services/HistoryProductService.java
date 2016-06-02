package foamenbot.services;

import foamenbot.model.HistoryProduct;

import java.util.Set;

public interface HistoryProductService {

    HistoryProduct findById(long id);
    void save(HistoryProduct historyProduct);
    void save(Set<HistoryProduct> historyProduct);
}
