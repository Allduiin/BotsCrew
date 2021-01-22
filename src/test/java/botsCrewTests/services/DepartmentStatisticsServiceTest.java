package botsCrewTests.services;

import dao.DepartmentDao;
import java.util.List;
import model.Department;
import model.Lector;
import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import services.DepartmentStaticsService;
import services.IncorrectDataService;
import services.impl.DepartmentStaticsServiceImpl;

public class DepartmentStatisticsServiceTest {
    private final IncorrectDataService incorrectDataService;
    private DepartmentStaticsService departmentStaticsService;
    private final static String TEST_DEPARTMENT_NAME = "BiologyDepartment";
    private final static String TEST_INCORRECT_MESSAGE =
            TEST_DEPARTMENT_NAME + " does not exists on our database";

    public DepartmentStatisticsServiceTest() {
        incorrectDataService = mock(IncorrectDataService.class);
        when(incorrectDataService.sayIncorrectDataRead(TEST_DEPARTMENT_NAME))
                .thenReturn(TEST_DEPARTMENT_NAME + " does not exists on our database");
    }

    @Test
    public void normalTest() {
        String expected = "assistants - 1\n"
                + "associate professors - 0\n"
                + "professors - 2\n";
        Lector lector1 = new Lector();
        lector1.setDegree(Lector.Degree.ASSISTANT);
        Lector lector2 = new Lector();
        lector2.setDegree(Lector.Degree.PROFESSOR);
        Lector lector3 = new Lector();
        lector3.setDegree(Lector.Degree.PROFESSOR);
        Department department = new Department();
        department.setLectors(List.of(lector1, lector2, lector3));
        DepartmentDao departmentDao = mock(DepartmentDao.class);
        when(departmentDao.getByName(TEST_DEPARTMENT_NAME)).thenReturn(department);
        departmentStaticsService =
                new DepartmentStaticsServiceImpl(departmentDao, incorrectDataService);
        Assert.assertEquals("Statistics is not correct count",
                expected, departmentStaticsService.takeDepartmentStatistics(TEST_DEPARTMENT_NAME));
    }

    @Test
    public void notExistedDepartmentTest() {
        DepartmentDao departmentDao = mock(DepartmentDao.class);
        departmentStaticsService =
                new DepartmentStaticsServiceImpl(departmentDao, incorrectDataService);
        Assert.assertEquals("Method must return warning message "
                        + "about incorrect name of department",
                TEST_INCORRECT_MESSAGE,
                departmentStaticsService.takeDepartmentStatistics(TEST_DEPARTMENT_NAME));
    }
}
