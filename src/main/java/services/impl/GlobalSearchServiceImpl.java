package services.impl;

import org.springframework.stereotype.Service;
import services.GlobalSearchService;

@Service
public class GlobalSearchServiceImpl implements GlobalSearchService {
    @Override
    public void globalSearch(String template) {
        System.out.println(template);
    }
}
