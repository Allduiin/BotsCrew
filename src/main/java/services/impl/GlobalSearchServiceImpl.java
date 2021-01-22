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
    public String globalSearch(String template) {
        List<String> templates = lectorDao.globalSearch(template);
        if (templates.size() == 0) {
            return ("No one was find by search '" + template + "'");
        }
        String result = templates.toString();
        return (result.substring(1, result.length() - 1));
    }
}
