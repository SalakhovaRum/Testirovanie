package helpers;

import appmanager.ApplicationManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;


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

        // Выполняем необходимые действия после входа
        driver.findElement(By.linkText("Sign Out")).click();
    }


}