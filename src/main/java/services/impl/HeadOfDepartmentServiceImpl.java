package services.impl;

import org.springframework.stereotype.Service;
import services.HeadOfDepartmentService;

@Service
public class HeadOfDepartmentServiceImpl implements HeadOfDepartmentService {
    @Override
    public void takeHeadOfDepartment(String departmentName) {
        System.out.println(departmentName);
    }
}
