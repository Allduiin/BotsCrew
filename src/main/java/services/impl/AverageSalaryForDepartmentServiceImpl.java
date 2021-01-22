package services.impl;

import dao.DepartmentDao;
import java.util.List;
import model.Department;
import model.Lector;
import org.springframework.stereotype.Service;
import services.AverageSalaryForDepartmentService;
import services.IncorrectDataService;

@Service
public class AverageSalaryForDepartmentServiceImpl implements AverageSalaryForDepartmentService {
    private final DepartmentDao departmentDao;
    private final IncorrectDataService incorrectDataService;

    public AverageSalaryForDepartmentServiceImpl(DepartmentDao departmentDao,
                                                 IncorrectDataService incorrectDataService) {
        this.departmentDao = departmentDao;
        this.incorrectDataService = incorrectDataService;
    }

    @Override
    public void takeAverageSalary(String departmentName) {
        Department department = departmentDao.getByName(departmentName);
        if (department == null) {
            incorrectDataService.sayIncorrectDataRead(departmentName);
            return;
        }
        int sum = 0;
        List<Lector> lectors = department.getLectors();
        for (Lector lector: lectors) {
            sum += lector.getSalary();
        }
        System.out.println("The average salary of" + departmentName
                + " is " + (double) sum / lectors.size());
    }
}
