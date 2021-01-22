package botsCrewTests.services;

import dao.DepartmentDao;
import model.Department;
import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import services.AddDepartmentService;
import services.impl.AddDepartmentServiceImpl;

public class AddDepartmentServiceTest {
    private final static String TEST_DEPARTMENT_NAME = "ChemistryDepartment";
    private final static Long TEST_ID = 1L;

    @Test
    public void normalAddDepartmentTest() {
        Department testDepartment = new Department();
        testDepartment.setName(TEST_DEPARTMENT_NAME);
        Department expected = new Department();
        expected.setId(TEST_ID);
        expected.setName(TEST_DEPARTMENT_NAME);
        DepartmentDao departmentDao = mock(DepartmentDao.class);
        when(departmentDao.add(testDepartment)).thenReturn(expected);
        AddDepartmentService addDepartmentService = new AddDepartmentServiceImpl(departmentDao);
        Assert.assertEquals("AddDepartmentService not correctly returns department",
                addDepartmentService.add(testDepartment), expected);
    }
}
