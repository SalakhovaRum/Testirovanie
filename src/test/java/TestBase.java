import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
    protected WebDriver driver;

    public TestBase() {
        // Установка WebDriver
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    public void login(Credentials credentials) {
        driver.findElement(By.linkText("Log In")).click();
        driver.findElement(By.name("username")).sendKeys(credentials.getUsername());
        driver.findElement(By.name("password")).sendKeys(credentials.getPassword());
        driver.findElement(By.cssSelector(".ui-button-text")).click();
    }

    public void test(String title, String content) {
        driver.findElement(By.name("notetitle")).click();
        driver.findElement(By.name("notetitle")).sendKeys(title);
        driver.findElement(By.id("textarea")).click();
        driver.findElement(By.id("textarea")).sendKeys(content);
        driver.findElement(By.id("autosave")).click();
        driver.findElement(By.name("makeprivate")).click();
        driver.findElement(By.xpath("//body[@id='page-wrap']/div[2]/div/div[7]/button/span")).click();
    }

    public void quit() {
        driver.quit();
    }
}
