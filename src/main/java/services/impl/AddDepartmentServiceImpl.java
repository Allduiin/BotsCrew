package services.impl;

import dao.DepartmentDao;
import model.Department;
import services.AddDepartmentService;

public class AddDepartmentServiceImpl implements AddDepartmentService {
    DepartmentDao departmentDao;

    @Override
    public Department add(Department department) {
        return departmentDao.add(department);
    }
}
