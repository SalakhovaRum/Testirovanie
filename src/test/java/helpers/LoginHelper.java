package helpers;

import appmanager.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginHelper extends HelperBase {

    public LoginHelper(ApplicationManager applicationManager, WebDriver driver) {
        super(applicationManager, driver);
    }

    public void openLoginPage() {
        driver.get("https://www.zippyjot.com/");
    }

    public void enterUsername(String username) {
        driver.findElement(By.name("username")).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(By.name("password")).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(By.cssSelector(".ui-button-text")).click();
    }

    public void login(String username, String password) {
        driver.findElement(By.linkText("Log In")).click();
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.cssSelector(".ui-button-text")).click();
    }

    // Добавленный метод для возврата WebDriver
    public WebDriver getDriver() {
        return driver;
    }

    // Метод для выхода из аккаунта
    public void logout() {
        driver.findElement(By.linkText("Sign Out")).click();
    }
}
