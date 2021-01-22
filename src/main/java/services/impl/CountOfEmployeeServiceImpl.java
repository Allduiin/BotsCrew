package services.impl;

import dao.DepartmentDao;
import model.Department;
import org.springframework.stereotype.Service;
import services.CountOfEmployeeService;
import services.IncorrectDataService;

@Service
public class CountOfEmployeeServiceImpl implements CountOfEmployeeService {
    private final DepartmentDao departmentDao;
    private final IncorrectDataService incorrectDataService;

    public CountOfEmployeeServiceImpl(DepartmentDao departmentDao,
                                      IncorrectDataService incorrectDataService) {
        this.departmentDao = departmentDao;
        this.incorrectDataService = incorrectDataService;
    }

    @Override
    public void takeEmployeeCount(String departmentName) {
        Department department = departmentDao.getByName(departmentName);
        if (department == null) {
            incorrectDataService.sayIncorrectDataRead(departmentName);
            return;
        }
        System.out.println(department.getLectors().size());
    }
}
