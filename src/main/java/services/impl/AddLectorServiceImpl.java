package services.impl;

import dao.LectorDao;
import dao.impl.LectorDaoImpl;
import model.Lector;
import services.AddLectorService;

public class AddLectorServiceImpl implements AddLectorService {

    private LectorDao lectorDao = new LectorDaoImpl();

    @Override
    public Lector add(Lector lector) {
        return lectorDao.add(lector);
    }
}
