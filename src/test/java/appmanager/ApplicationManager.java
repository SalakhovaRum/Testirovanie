package appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import helpers.LoginHelper;
import helpers.NavigationHelper;

public class ApplicationManager {
    // Добавление переменной ThreadLocal для хранения экземпляра ApplicationManager
    private static final ThreadLocal<ApplicationManager> instance = new ThreadLocal<>();

    private final WebDriver driver;
    private final NavigationHelper navigationHelper;
    private final LoginHelper loginHelper;

    // Сделать ApplicationManager классом Singleton: добавить статичный метод getInstance() и изменить модификатор доступа у конструктора ApplicationManager на private
    private ApplicationManager() {
        // Установка WebDriver
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");
        driver = new ChromeDriver();

        // Инициализация хелперов
        navigationHelper = new NavigationHelper(this, driver);
        loginHelper = new LoginHelper(this, driver);
    }

    // Добавление статического метода getInstance() для получения экземпляра ApplicationManager
    public static ApplicationManager getInstance() {
        if (instance.get() == null) {
            instance.set(new ApplicationManager());
        }
        return instance.get();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public LoginHelper getLoginHelper() {
        return loginHelper;
    }

    // Создание деструктора для освобождения ресурсов
    public void quit() {
        driver.quit();
    }
}
