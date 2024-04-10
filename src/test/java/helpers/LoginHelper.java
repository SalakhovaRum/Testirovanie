// В файле LoginHelper.java
package helpers;

import appmanager.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginHelper extends HelperBase {

    public LoginHelper(ApplicationManager applicationManager, WebDriver driver) {
        super(applicationManager, driver);
    }

    public void login(String username, String password) {
        driver.findElement(By.linkText("Log In")).click();
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.cssSelector(".ui-button-text")).click();
    }

    // Другие методы, если нужно
}
