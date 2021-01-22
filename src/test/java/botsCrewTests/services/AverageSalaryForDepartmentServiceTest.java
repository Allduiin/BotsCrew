package botsCrewTests.services;

import dao.DepartmentDao;
import java.util.List;
import model.Department;
import model.Lector;
import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import services.AverageSalaryForDepartmentService;
import services.IncorrectDataService;
import services.impl.AverageSalaryForDepartmentServiceImpl;

public class AverageSalaryForDepartmentServiceTest {
    private final IncorrectDataService incorrectDataService;
    private AverageSalaryForDepartmentService averageSalaryForDepartmentService;
    private final static String TEST_DEPARTMENT_NAME = "PhysicsDepartment";
    private final static String TEST_INCORRECT_MESSAGE =
            TEST_DEPARTMENT_NAME + " does not exists on our database";
    private final static Long SALARY1 = 1000L;
    private final static Long SALARY2 = 10000L;

    public AverageSalaryForDepartmentServiceTest() {
        incorrectDataService = mock(IncorrectDataService.class);
        when(incorrectDataService.sayIncorrectDataRead(TEST_DEPARTMENT_NAME))
                .thenReturn(TEST_DEPARTMENT_NAME + " does not exists on our database");
    }

    @Test
    public void normalTest() {
        String expected = "The average salary of PhysicsDepartment is 5500.0";
        Lector lector1 = new Lector();
        lector1.setSalary(SALARY1);
        Lector lector2 = new Lector();
        lector2.setSalary(SALARY2);
        Department department = new Department();
        department.setLectors(List.of(lector1, lector2));
        DepartmentDao departmentDao = mock(DepartmentDao.class);
        when(departmentDao.getByName(TEST_DEPARTMENT_NAME)).thenReturn(department);
        averageSalaryForDepartmentService =
                new AverageSalaryForDepartmentServiceImpl(departmentDao, incorrectDataService);
        Assert.assertEquals("AverageSalary is not correct count",
                expected, averageSalaryForDepartmentService.takeAverageSalary(TEST_DEPARTMENT_NAME));
    }

    @Test
    public void notExistedDepartmentTest() {
        DepartmentDao departmentDao = mock(DepartmentDao.class);
        when(departmentDao.getByName(TEST_DEPARTMENT_NAME)).thenReturn(null);
        averageSalaryForDepartmentService =
                new AverageSalaryForDepartmentServiceImpl(departmentDao, incorrectDataService);
        Assert.assertEquals("Method must return warning message "
                        + "about incorrect name of department",
                TEST_INCORRECT_MESSAGE,
                averageSalaryForDepartmentService.takeAverageSalary(TEST_DEPARTMENT_NAME));
    }
}
