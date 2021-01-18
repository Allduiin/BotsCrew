package services.impl;

import services.HeadOfDepartmentService;

public class HeadOfDepartmentServiceImpl implements HeadOfDepartmentService {
    @Override
    public void takeHeadOfDepartment(String departmentName) {
        System.out.println(departmentName);
    }
}
