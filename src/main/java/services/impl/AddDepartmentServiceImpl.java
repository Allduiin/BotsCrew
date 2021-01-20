package services.impl;

import dao.DepartmentDao;
import model.Department;
import org.springframework.stereotype.Service;
import services.AddDepartmentService;

@Service
public class AddDepartmentServiceImpl implements AddDepartmentService {
    private final DepartmentDao departmentDao;

    public AddDepartmentServiceImpl(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    public Department add(Department department) {
        return departmentDao.add(department);
    }
}
