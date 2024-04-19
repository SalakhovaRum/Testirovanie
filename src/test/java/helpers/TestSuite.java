package helpers;

import appmanager.ApplicationManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        LoginHelperTest.class,
        NavigationHelperTest.class,
        DeleteHelperTest.class,

})
public class TestSuite {

    private static ApplicationManager applicationManager;

    @BeforeClass
    public static void setUp() {
        // Получение экземпляра ApplicationManager
        applicationManager = ApplicationManager.getInstance();
    }

    @AfterClass
    public static void tearDown() {
        // Завершение работы ApplicationManager после выполнения всех тестов
        if (applicationManager != null) {
            applicationManager.quit();
        }
    }
}
