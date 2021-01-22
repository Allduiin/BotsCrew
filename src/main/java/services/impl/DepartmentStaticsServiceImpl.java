package services.impl;

import dao.DepartmentDao;
import java.util.List;
import model.Department;
import model.Lector;
import org.springframework.stereotype.Service;
import services.DepartmentStaticsService;
import services.IncorrectDataService;

@Service
public class DepartmentStaticsServiceImpl implements DepartmentStaticsService {
    private final DepartmentDao departmentDao;
    private final IncorrectDataService incorrectDataService;

    public DepartmentStaticsServiceImpl(DepartmentDao departmentDao,
                                        IncorrectDataService incorrectDataService) {
        this.departmentDao = departmentDao;
        this.incorrectDataService = incorrectDataService;
    }

    @Override
    public void takeDepartmentStatistics(String departmentName) {
        int assistants = 0;
        int associateProfessors = 0;
        int professors = 0;
        Department department = departmentDao.getByName(departmentName);
        if (department == null) {
            incorrectDataService.sayIncorrectDataRead(departmentName);
            return;
        }
        List<Lector> lectors = department.getLectors();
        for (Lector lector: lectors) {
            switch (lector.getDegree()) {
                case ASSISTANT:
                    assistants++;
                    break;
                case ASSOCIATE_PROFESSOR:
                    associateProfessors++;
                    break;
                case PROFESSOR:
                    professors++;
                    break;
                default:
                    throw new RuntimeException("Lector without degree" + lector.getName());
            }
        }
        System.out.println("assistans - " + assistants + ".\n"
                + "associate professors - " + associateProfessors + "\n"
                + "professors - " + professors + "\n");
    }
}
