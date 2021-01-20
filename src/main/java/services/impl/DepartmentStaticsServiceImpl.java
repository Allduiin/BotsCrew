package services.impl;

import org.springframework.stereotype.Service;
import services.DepartmentStaticsService;

@Service
public class DepartmentStaticsServiceImpl implements DepartmentStaticsService {
    @Override
    public void takeDepartmentStatistics(String departmentName) {
        System.out.println(departmentName);
    }
}
