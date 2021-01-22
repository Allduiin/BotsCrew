package botsCrewTests.services;

import dao.LectorDao;
import model.Lector;
import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import services.AddLectorService;
import services.impl.AddLectorServiceImpl;

public class AddLectorServiceTest {
    private final static String TEST_TEST_LECTOR_NAME = "ChemistryLector";
    private final static Long TEST_ID = 1L;

    @Test
    public void normalAddLectorTest() {
        Lector testLector = new Lector();
        testLector.setName(TEST_TEST_LECTOR_NAME);
        Lector expected = new Lector();
        expected.setId(TEST_ID);
        expected.setName(TEST_TEST_LECTOR_NAME);
        LectorDao LectorDao = mock(LectorDao.class);
        when(LectorDao.add(testLector)).thenReturn(expected);
        AddLectorService addLectorService = new AddLectorServiceImpl(LectorDao);
        Assert.assertEquals("AddLectorService not correctly returns Lector",
                addLectorService.add(testLector), expected);
    }
}
