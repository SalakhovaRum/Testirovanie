package helpers;

import appmanager.ApplicationManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginHelperTest {

    private WebDriver driver;
    private ApplicationManager applicationManager;
    private LoginHelper loginHelper;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        applicationManager = new ApplicationManager();
        loginHelper = new LoginHelper(applicationManager, driver);
        loginHelper.openLoginPage();
    }

    @Test
    public void testLogin() {
        String username = "ruzalina15";
        String password = "030703";
        loginHelper.login(username, password);

    }

}
