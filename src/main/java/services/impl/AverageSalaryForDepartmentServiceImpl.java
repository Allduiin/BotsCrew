package services.impl;

import services.AverageSalaryForDepartmentService;

public class AverageSalaryForDepartmentServiceImpl implements AverageSalaryForDepartmentService {
    @Override
    public void takeAverageSalary(String departmentName) {
        System.out.println(departmentName);
    }
}
