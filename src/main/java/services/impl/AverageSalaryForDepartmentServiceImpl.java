package services.impl;

import dao.DepartmentDao;
import java.util.List;
import model.Department;
import model.Lector;
import org.springframework.stereotype.Service;
import services.AverageSalaryForDepartmentService;

@Service
public class AverageSalaryForDepartmentServiceImpl implements AverageSalaryForDepartmentService {
    private final DepartmentDao departmentDao;

    public AverageSalaryForDepartmentServiceImpl(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    public void takeAverageSalary(String departmentName) {
        Department department = departmentDao.getByName(departmentName);
        int sum = 0;
        List<Lector> lectors = department.getLectors();
        for (Lector lector: lectors) {
            sum += lector.getSalary();
        }
        System.out.println("The average salary of" + departmentName + " is " + (double) sum/lectors.size());
    }
}
