package appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import helpers.LoginHelper;
import helpers.NavigationHelper;

public class ApplicationManager {
    private WebDriver driver;
    private NavigationHelper navigationHelper;
    private LoginHelper loginHelper;

    public ApplicationManager() {
        // Установка WebDriver
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");
        driver = new ChromeDriver();

        // Инициализация хелперов
        navigationHelper = new NavigationHelper(this, driver);
        loginHelper = new LoginHelper(this, driver);
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

    // Другие методы и поля, если нужно

    public void quit() {
        driver.quit();
    }
}
