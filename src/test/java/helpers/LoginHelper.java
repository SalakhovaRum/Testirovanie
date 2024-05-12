package helpers;

import appmanager.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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
        if (IsLoggedIn()) {
            if (IsLoggedIn(username)) {
                return; // Уже залогинены под нужным пользователем
            } else {
                logout(); // Логаут, если залогинены, но не под нужным пользователем
            }
        }
        // Если не залогинены или залогинены не под нужным пользователем, выполняем вход
        driver.findElement(By.linkText("Log In")).click();
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    public boolean IsLoggedIn() {
        try {
            // Проверяем наличие элемента, свидетельствующего о том, что пользователь залогинен
            return driver.findElement(By.linkText("Sign Out")).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean IsLoggedIn(String username) {
        try {
            // Проверяем наличие элемента, свидетельствующего о том, что пользователь залогинен под указанным именем
            String welcomeMessage = "Welcome, " + username;
            return driver.findElement(By.xpath("//div[contains(text(), '" + welcomeMessage + "')]")).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void logout() {
        // Проверяем, залогинены ли мы перед логаутом
        if (IsLoggedIn()) {
            driver.findElement(By.linkText("Sign Out")).click();
        }
    }
}
