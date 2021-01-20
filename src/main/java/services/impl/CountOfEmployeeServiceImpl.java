package services.impl;

import org.springframework.stereotype.Service;
import services.CountOfEmployeeService;

@Service
public class CountOfEmployeeServiceImpl implements CountOfEmployeeService {
    @Override
    public void takeEmployeeCount(String departmentName) {
        System.out.println(departmentName);
    }
}
