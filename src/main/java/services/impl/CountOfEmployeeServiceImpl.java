package services.impl;

import services.CountOfEmployeeService;

public class CountOfEmployeeServiceImpl implements CountOfEmployeeService {

    @Override
    public void takeEmployeeCount(String departmentName) {
        System.out.println(departmentName);
    }
}
