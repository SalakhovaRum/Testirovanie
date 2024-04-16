package helpers;

import appmanager.ApplicationManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationHelperTest {

    private WebDriver driver;
    private ApplicationManager applicationManager;
    private NavigationHelper navigationHelper;

    @Before
    public void setUp() {
        // Инициализация драйвера Chrome
        driver = new ChromeDriver();

        // Создание экземпляра ApplicationManager
        applicationManager = new ApplicationManager();

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
