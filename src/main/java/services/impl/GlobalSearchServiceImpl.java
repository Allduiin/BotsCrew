package services.impl;

import services.GlobalSearchService;

public class GlobalSearchServiceImpl implements GlobalSearchService {
    @Override
    public void globalSearch(String template) {
        System.out.println(template);
    }
}
