package services.impl;

import dao.DepartmentDao;
import model.Department;
import org.springframework.stereotype.Service;
import services.HeadOfDepartmentService;
import services.IncorrectDataService;

@Service
public class HeadOfDepartmentServiceImpl implements HeadOfDepartmentService {
    private final DepartmentDao departmentDao;
    private final IncorrectDataService incorrectDataService;

    public HeadOfDepartmentServiceImpl(DepartmentDao departmentDao,
                                       IncorrectDataService incorrectDataService) {
        this.departmentDao = departmentDao;
        this.incorrectDataService = incorrectDataService;
    }

    @Override
    public String takeHeadOfDepartment(String departmentName) {
        Department department = departmentDao.getByName(departmentName);
        if (department == null) {
            return incorrectDataService.sayIncorrectDataRead(departmentName);
        }
        return (departmentDao.getByName(departmentName).getHeadOfDepartment().getName());
    }
}
