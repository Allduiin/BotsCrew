package botsCrewTests.services;

import dao.DepartmentDao;
import java.util.Collections;
import java.util.List;
import model.Department;
import model.Lector;
import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import services.CountOfEmployeeService;
import services.IncorrectDataService;
import services.impl.CountOfEmployeeServiceImpl;

public class CountOfEmployeeServiceTest {
    private final IncorrectDataService incorrectDataService;
    private CountOfEmployeeService countOfEmployeeService;
    private final static String TEST_DEPARTMENT_NAME = "PhysicsDepartment";
    private final static String TEST_INCORRECT_MESSAGE =
            TEST_DEPARTMENT_NAME + " does not exists on our database";

    public CountOfEmployeeServiceTest() {
        incorrectDataService = mock(IncorrectDataService.class);
        when(incorrectDataService.sayIncorrectDataRead(TEST_DEPARTMENT_NAME))
                .thenReturn(TEST_DEPARTMENT_NAME + " does not exists on our database");
    }

    @Test
    public void normalTest() {
        Lector lector1 = new Lector();
        Lector lector2 = new Lector();
        Lector lector3 = new Lector();
        Department department = new Department();
        department.setLectors(List.of(lector1, lector2, lector3));
        DepartmentDao departmentDao = mock(DepartmentDao.class);
        when(departmentDao.getByName(TEST_DEPARTMENT_NAME)).thenReturn(department);
        countOfEmployeeService = new CountOfEmployeeServiceImpl(departmentDao, incorrectDataService);
        Assert.assertEquals("Incorrect count of templates", "3",
                countOfEmployeeService.takeEmployeeCount(TEST_DEPARTMENT_NAME));
    }

    @Test
    public void nullLectorsTest() {
        Department department = new Department();
        DepartmentDao departmentDao = mock(DepartmentDao.class);
        when(departmentDao.getByName(TEST_DEPARTMENT_NAME)).thenReturn(department);
        countOfEmployeeService = new CountOfEmployeeServiceImpl(departmentDao, incorrectDataService);
        Assert.assertEquals("Incorrect count of templates", "0",
                countOfEmployeeService.takeEmployeeCount(TEST_DEPARTMENT_NAME));
    }

    @Test
    public void zeroLectorsTest() {
        Department department = new Department();
        department.setLectors(Collections.emptyList());
        DepartmentDao departmentDao = mock(DepartmentDao.class);
        when(departmentDao.getByName(TEST_DEPARTMENT_NAME)).thenReturn(department);
        countOfEmployeeService = new CountOfEmployeeServiceImpl(departmentDao, incorrectDataService);
        Assert.assertEquals("Incorrect count of templates", "0",
                countOfEmployeeService.takeEmployeeCount(TEST_DEPARTMENT_NAME));
    }

    @Test
    public void notExistedDepartmentTest() {
        DepartmentDao departmentDao = mock(DepartmentDao.class);
        when(departmentDao.getByName(TEST_DEPARTMENT_NAME)).thenReturn(null);
        countOfEmployeeService =
                new CountOfEmployeeServiceImpl(departmentDao, incorrectDataService);
        Assert.assertEquals("Method must return warning message "
                        + "about incorrect name of department",
                TEST_INCORRECT_MESSAGE,
                countOfEmployeeService.takeEmployeeCount(TEST_DEPARTMENT_NAME));
    }
}
