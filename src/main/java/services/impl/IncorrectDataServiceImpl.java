package services.impl;

import org.springframework.stereotype.Service;
import services.IncorrectDataService;

@Service
public class IncorrectDataServiceImpl implements IncorrectDataService {
    @Override
    public void sayIncorrectDataRead(String data) {
        System.out.println(data + " does not exists on our database");
    }
}
