import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class ff {
  private WebDriver driver;

  @Before
  public void setUp() {
    driver = new ChromeDriver();
    driver.manage().window().setSize(new Dimension(1200, 800)); // Установка размера окна браузера
  }

  @After
  public void tearDown() {
    driver.quit();
  }

  @Test
  public void testDeleteNote() {
    driver.get("https://www.zippyjot.com/");

    // Ожидаем, пока ссылка "Log In" станет кликабельной и кликаем на неё
    WebElement loginLink = new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.elementToBeClickable(By.linkText("Log In")));
    loginLink.click();

    // Заполняем поля логина и пароля
    WebElement usernameInput = new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
    usernameInput.sendKeys("ruzalina15");

    WebElement passwordInput = driver.findElement(By.name("password"));
    passwordInput.sendKeys("030703");

    // Ожидаем, пока кнопка "Log In" станет кликабельной и кликаем на неё
    WebElement loginButton = new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.elementToBeClickable(By.cssSelector(".ui-button-text")));
    loginButton.click();

    // Ожидаем, пока ссылка "Delete Note" станет кликабельной и кликаем на неё
    WebElement deleteNoteLink = new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.elementToBeClickable(By.linkText("Delete Note")));
    deleteNoteLink.click();

    // Переключаемся на алерт и проверяем текст
    String alertText = new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.alertIsPresent()).getText();
    assertEquals("Do you really want to Delete this note?", alertText);
    driver.switchTo().alert().accept();
  }
}
