import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

public class TestikTest extends TestBase {

  @Test
  public void test() {
    driver.get("https://www.zippyjot.com/");
    driver.manage().window().setSize(new Dimension(550, 699));

    WebElement notetitle = driver.findElement(By.name("notetitle"));
    notetitle.click();
    notetitle.sendKeys("Что-то тут создаем");

    WebElement textarea = driver.findElement(By.id("textarea"));
    textarea.click();
    textarea.sendKeys("Все отлично");

    WebElement button = driver.findElement(By.xpath("//body[@id='page-wrap']/form/div[4]/button"));
    button.click();

  }


  @Test
  public void testik() {
    driver.get("https://www.zippyjot.com/");
    driver.manage().window().setSize(new Dimension(550, 699));
    Credentials credentials = new Credentials("ruzalina15", "030703");
    login(credentials);
  }
}
