package services.impl;

import org.springframework.stereotype.Service;
import services.IncorrectDataService;

@Service
public class IncorrectDataServiceImpl implements IncorrectDataService {
    @Override
    public String sayIncorrectDataRead(String data) {
        return (data + " does not exists on our database");
    }
}
