package services.impl;

import services.DepartmentStaticsService;

public class DepartmentStaticsServiceImpl implements DepartmentStaticsService {
    @Override
    public void takeDepartmentStatistics(String departmentName) {
        System.out.println(departmentName);
    }
}
