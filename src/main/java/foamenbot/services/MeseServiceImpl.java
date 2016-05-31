package foamenbot.services;

import foamenbot.model.Mese;
import foamenbot.repositories.MeseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
public class MeseServiceImpl implements MeseService{

    @Autowired
    private MeseRepository meseRepository;

    @Override
    public Set<Mese> findAll() {
        return meseRepository.findAll();
    }

    @Override
    public void save(Mese masa) {
        meseRepository.save(masa);
    }

    @Override
    public void delete(Mese masa) {
        meseRepository.delete(masa);
    }
}
