package services.impl;

import dao.LectorDao;
import model.Lector;
import org.springframework.stereotype.Service;
import services.AddLectorService;

@Service
public class AddLectorServiceImpl implements AddLectorService {

    private final LectorDao lectorDao;

    public AddLectorServiceImpl(LectorDao lectorDao) {
        this.lectorDao = lectorDao;
    }

    @Override
    public Lector add(Lector lector) {
        return lectorDao.add(lector);
    }
}
