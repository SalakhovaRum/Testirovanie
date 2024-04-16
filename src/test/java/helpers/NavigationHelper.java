package helpers;

import appmanager.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(ApplicationManager applicationManager, WebDriver driver) {
        super(applicationManager, driver);
    }

    public void openHomePage() {
        driver.get("https://www.zippyjot.com/");
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