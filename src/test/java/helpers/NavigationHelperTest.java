package helpers;

import appmanager.ApplicationManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class NavigationHelperTest {

    private WebDriver driver;
    private ApplicationManager applicationManager;
    private NavigationHelper navigationHelper;

    @Before
    public void setUp() {
        // Получение экземпляра ApplicationManager
        applicationManager = ApplicationManager.getInstance();

        // Получение драйвера из ApplicationManager
        driver = applicationManager.getDriver();

        // Инициализация navigationHelper с передачей applicationManager и driver
        navigationHelper = new NavigationHelper(applicationManager, driver);

        // Открытие домашней страницы
        navigationHelper.openHomePage();
    }


    @Test
    public void testNavigation() {
        try {
            // Задание заголовка и содержимого для теста
            String title = "Добавилось";
            String content = "Все отлично";

            // Вызов метода test из navigationHelper
            navigationHelper.test(title, content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
