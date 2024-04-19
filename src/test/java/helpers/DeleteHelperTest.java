package helpers;

import appmanager.ApplicationManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DeleteHelperTest {

    private ApplicationManager applicationManager;
    private WebDriver driver;

    @Before
    public void setUp() {
        // Инициализация и получение экземпляра приложения
        applicationManager = ApplicationManager.getInstance();
        // Получение драйвера браузера
        driver = applicationManager.getDriver();
        // Открытие страницы входа
        driver.get("https://www.zippyjot.com/login/");
        // Установка размера окна браузера
        driver.manage().window().setSize(new Dimension(786, 824));
        // Выполнение входа с заданными учетными данными
        login("ruzalina15", "030703");
    }

    @After
    public void tearDown() {
        // Завершение работы драйвера после выполнения теста
        driver.quit();
    }

    @Test
    public void testDelete() {
        // Находим ссылку "Delete Note" и кликаем на неё
        WebElement deleteNoteLink = driver.findElement(By.linkText("Delete Note"));
        deleteNoteLink.click();

        // Ожидаем появления диалогового окна и получаем его
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

        // Проверяем текст в диалоговом окне
        assertThat(driver.switchTo().alert().getText(), is("Do you really want to Delete this note?"));
        // Принимаем диалоговое окно (подтверждаем удаление)
        driver.switchTo().alert().accept();
    }

    // Метод для выполнения входа на страницу
    private void login(String username, String password) {
        // Находим поле ввода логина и вводим логин
        WebElement usernameInput = driver.findElement(By.name("username"));
        usernameInput.sendKeys(username);

        // Находим поле ввода пароля и вводим пароль
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys(password);

        // Находим кнопку входа и кликаем на неё
        WebElement loginButton = driver.findElement(By.cssSelector(".ui-button-text"));
        loginButton.click();
    }
}
