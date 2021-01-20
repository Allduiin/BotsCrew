package services.impl;

import dao.DepartmentDao;
import model.Department;
import org.springframework.stereotype.Service;
import services.CountOfEmployeeService;

@Service
public class CountOfEmployeeServiceImpl implements CountOfEmployeeService {
    private final DepartmentDao departmentDao;

    public CountOfEmployeeServiceImpl(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    public void takeEmployeeCount(String departmentName) {
        Department department = departmentDao.getByName(departmentName);
        System.out.println(department.getLectors().size());
    }
}
