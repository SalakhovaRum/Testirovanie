import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;


public class TestBase {
    protected WebDriver driver;
    protected Map<String, Object> vars;
    protected JavascriptExecutor js;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<>();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    public void login(Credentials credentials) {
        driver.findElement(By.linkText("Log In")).click();
        driver.findElement(By.name("username")).sendKeys(credentials.getUsername());
        driver.findElement(By.name("password")).sendKeys(credentials.getPassword());
        driver.findElement(By.cssSelector(".ui-button-text")).click();
    }
}
