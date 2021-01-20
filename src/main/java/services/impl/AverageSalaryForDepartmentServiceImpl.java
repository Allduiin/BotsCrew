package services.impl;

import org.springframework.stereotype.Service;
import services.AverageSalaryForDepartmentService;

@Service
public class AverageSalaryForDepartmentServiceImpl implements AverageSalaryForDepartmentService {
    @Override
    public void takeAverageSalary(String departmentName) {
        System.out.println(departmentName);
    }
}
