package services.impl;

import dao.LectorDao;
import java.util.List;
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
        List<String> templates = lectorDao.globalSearch(template);
        if (templates.size() == 0) {
            System.out.println("No one was find with characters " + template);
            return;
        }
        String result = templates.toString();
        System.out.println(result.substring(1, result.length() - 1));
    }
}
