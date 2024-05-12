package helpers;

import appmanager.ApplicationManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginHelperTest {

    private ApplicationManager applicationManager;
    private LoginHelper loginHelper;

    @Before
    public void setUp() {
        applicationManager = ApplicationManager.getInstance();
        WebDriver driver = applicationManager.getDriver();
        loginHelper = new LoginHelper(applicationManager, driver);
        loginHelper.openLoginPage();
    }

    @Test
    public void testLogin() {
        String username = "ruzalina15";
        String password = "030703";
        loginHelper.login(username, password);

        // Получаем экземпляр WebDriver из LoginHelper
        WebDriver driver = loginHelper.getDriver();

        // Утверждение: Проверяем, что после входа появляется кнопка "Sign Out"
        boolean isSignedIn = driver.findElement(By.linkText("Sign Out")).isDisplayed();
        Assert.assertTrue("Пользователь не вошел в систему!", isSignedIn);

        // Выполняем необходимые действия после входа
        driver.findElement(By.linkText("Sign Out")).click();
    }

    @Test
    public void testLoginWithValidData() {
        loginHelper.logout(); // Принудительный выход перед тестом
        String validUsername = "ruzalina15";
        String validPassword = "030703";
        loginHelper.login(validUsername, validPassword);

        // Получаем экземпляр WebDriver из LoginHelper
        WebDriver driver = loginHelper.getDriver();

        // Утверждение: Проверяем, что после входа появляется кнопка "Sign Out"
        boolean isSignedIn = driver.findElement(By.linkText("Sign Out")).isDisplayed();
        Assert.assertTrue("Пользователь не вошел в систему!", isSignedIn);

        // Выполняем необходимые действия после входа
        driver.findElement(By.linkText("Sign Out")).click();
    }

    @Test
    public void testLoginWithInvalidData() {
        loginHelper.logout(); // Принудительный выход перед тестом
        String invalidUsername = "ruzalina";
        String invalidPassword = "15";
        loginHelper.login(invalidUsername, invalidPassword);

        // Получаем экземпляр WebDriver из LoginHelper
        WebDriver driver = loginHelper.getDriver();

        // Утверждение: Проверяем, что после входа не появляется кнопка "Sign Out"
        boolean isSignedIn = driver.findElements(By.linkText("Sign Out")).isEmpty();
        Assert.assertFalse("Пользователь вошел в систему с неверными данными!", isSignedIn);
    }
}
