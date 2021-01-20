package services.impl;

import dao.LectorDao;
import org.springframework.stereotype.Service;
import services.GlobalSearchService;

@Service
public class GlobalSearchServiceImpl implements GlobalSearchService {
    private final LectorDao lectorDao;

    public GlobalSearchServiceImpl(LectorDao lectorDao) {
        this.lectorDao = lectorDao;
    }

    @Override
    public void globalSearch(String template) {
        System.out.println(lectorDao.globalSearch(template));
    }
}
