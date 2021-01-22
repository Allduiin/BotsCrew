package botsCrewTests.services;

import dao.LectorDao;
import java.util.Collections;
import java.util.List;
import model.Department;
import model.Lector;
import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import services.GlobalSearchService;
import services.impl.GlobalSearchServiceImpl;

public class GlobalSearchServiceTest {
    private GlobalSearchService globalSearchService;
    private final static String TEST_DEPARTMENT_NAME = "ChemistryDepartment";
    private final static String TEST_INCORRECT_MESSAGE =
            TEST_DEPARTMENT_NAME + " does not exists on our database";
    private final static String TEST_LECTOR_NAME1 = "Viktor Bojarski";
    private final static String TEST_LECTOR_NAME2 = "Viktor Klymenko";
    private final static String TEST_LECTOR_NAME3 = "Borys Prokopenko";

    @Test
    public void normalTest() {
        Lector lector1 = new Lector();
        lector1.setName(TEST_LECTOR_NAME1);
        Lector lector2 = new Lector();
        lector2.setName(TEST_LECTOR_NAME2);
        Lector lector3 = new Lector();
        lector3.setName(TEST_LECTOR_NAME3);
        Department department = new Department();
        department.setLectors(List.of(lector1, lector2, lector3));
        LectorDao lectorDao = mock(LectorDao.class);
        when(lectorDao.globalSearch("enko"))
                .thenReturn(List.of(lector2.getName(), lector3.getName()));
        when(lectorDao.globalSearch("Viktor"))
                .thenReturn(List.of(lector1.getName(), lector2.getName()));
        when(lectorDao.globalSearch("o"))
                .thenReturn(List.of(lector1.getName(), lector2.getName(), lector3.getName()));
        globalSearchService =
                new GlobalSearchServiceImpl(lectorDao);

        String expected1 = TEST_LECTOR_NAME2 + ", " + TEST_LECTOR_NAME3;
        String expected2 = TEST_LECTOR_NAME1 + ", " + TEST_LECTOR_NAME2;
        String expected3 = TEST_LECTOR_NAME1 + ", "
                + TEST_LECTOR_NAME2 + ", " + TEST_LECTOR_NAME3;
        Assert.assertEquals("Incorrect search work",
                expected1, globalSearchService.globalSearch("enko"));
        Assert.assertEquals("Incorrect search work",
                expected2, globalSearchService.globalSearch("Viktor"));
        Assert.assertEquals("Incorrect search work",
                expected3, globalSearchService.globalSearch("o"));
    }

    @Test
    public void notExistedSearchesTest() {
        LectorDao lectorDao = mock(LectorDao.class);
        when(lectorDao.globalSearch("not existed name"))
                .thenReturn(Collections.emptyList());
        globalSearchService =
                new GlobalSearchServiceImpl(lectorDao);
        String expected = "No one was find by search 'not existed name'";
        Assert.assertEquals("Incorrect search return with empty search list",
                expected, globalSearchService.globalSearch("not existed name"));
    }
}
