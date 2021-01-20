package services.impl;

import dao.DepartmentDao;
import org.springframework.stereotype.Service;
import services.HeadOfDepartmentService;

@Service
public class HeadOfDepartmentServiceImpl implements HeadOfDepartmentService {
    private final DepartmentDao departmentDao;

    public HeadOfDepartmentServiceImpl(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    public void takeHeadOfDepartment(String departmentName) {
        System.out.println(departmentDao.getByName(departmentName).getHeadOfDepartment().getName());
    }
}
