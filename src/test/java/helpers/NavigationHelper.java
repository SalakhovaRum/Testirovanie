package helpers;

import appmanager.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class NavigationHelper extends HelperBase {

    public NavigationHelper(ApplicationManager applicationManager, WebDriver driver) {
        super(applicationManager, driver);
    }

    public void openHomePage() {
        driver.get("https://www.zippyjot.com/");
        driver.manage().window().maximize(); // Максимизируем окно при открытии
    }

    public void hoverOverElement(String elementText) {
        WebElement element = driver.findElement(By.linkText(elementText));
        Actions builder = new Actions(driver);
        builder.moveToElement(element).perform();
    }

    public void clickElement(String elementText) {
        WebElement element = driver.findElement(By.linkText(elementText));
        element.click();
    }

    public void scrollToElement(String elementText) {
        WebElement element = driver.findElement(By.linkText(elementText));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void scrollToTop() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
    }

    public void sendKeysToElementById(String elementId, String keys) {
        WebElement element = driver.findElement(By.id(elementId));
        element.sendKeys(keys);
    }

    public void scrollToElementById(String elementId, int xOffset, int yOffset) {
        WebElement element = driver.findElement(By.id(elementId));
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(" + element.getLocation().x + ", " + element.getLocation().y + ")");
    }

    public void test(String title, String content) {
        driver.findElement(By.name("notetitle")).click();
        driver.findElement(By.name("notetitle")).sendKeys(title);
        driver.findElement(By.id("textarea")).click();
        driver.findElement(By.id("textarea")).sendKeys(content);
        driver.findElement(By.id("autosave")).click();
        driver.findElement(By.name("makeprivate")).click();
        driver.findElement(By.xpath("//body[@id='page-wrap']/div[2]/div/div[7]/button/span"))
                .click();
    }
}