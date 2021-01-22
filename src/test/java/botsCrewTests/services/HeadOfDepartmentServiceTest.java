package botsCrewTests.services;

import dao.DepartmentDao;
import model.Department;
import model.Lector;
import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import services.HeadOfDepartmentService;
import services.IncorrectDataService;
import services.impl.HeadOfDepartmentServiceImpl;

public class HeadOfDepartmentServiceTest {
    private final IncorrectDataService incorrectDataService;
    private HeadOfDepartmentService headOfDepartmentService;
    private final static String TEST_DEPARTMENT_NAME = "PhysicsDepartment";
    private final static String TEST_INCORRECT_MESSAGE =
            TEST_DEPARTMENT_NAME + " does not exists on our database";
    private final static String TEST_LECTOR_NAME = "Inna Plushenko";

    public HeadOfDepartmentServiceTest() {
        incorrectDataService = mock(IncorrectDataService.class);
        when(incorrectDataService.sayIncorrectDataRead(TEST_DEPARTMENT_NAME))
                .thenReturn(TEST_DEPARTMENT_NAME + " does not exists on our database");
    }

    @Test
    public void normalTest() {
        Lector lector = new Lector();
        lector.setName(TEST_LECTOR_NAME);
        Department department = new Department();
        department.setHeadOfDepartment(lector);
        DepartmentDao departmentDao = mock(DepartmentDao.class);
        when(departmentDao.getByName(TEST_DEPARTMENT_NAME)).thenReturn(department);
        headOfDepartmentService =
                new HeadOfDepartmentServiceImpl(departmentDao, incorrectDataService);
        Assert.assertEquals("Incorrect showing Head of department",
                TEST_LECTOR_NAME, headOfDepartmentService.takeHeadOfDepartment(TEST_DEPARTMENT_NAME));
    }

    @Test
    public void notExistedDepartmentTest() {
        DepartmentDao departmentDao = mock(DepartmentDao.class);
        when(departmentDao.getByName(TEST_DEPARTMENT_NAME)).thenReturn(null);
        headOfDepartmentService =
                new HeadOfDepartmentServiceImpl(departmentDao, incorrectDataService);
        Assert.assertEquals("Method must return warning message "
                        + "about incorrect name of department",
                TEST_INCORRECT_MESSAGE,
                headOfDepartmentService.takeHeadOfDepartment(TEST_DEPARTMENT_NAME));
    }
}
