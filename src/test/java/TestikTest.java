import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

public class TestikTest extends TestBase {

  @Test
  public void testEntityCreation() {
    // Временно повторяем код для авторизации
    driver.get("https://www.zippyjot.com/");
    driver.manage().window().setSize(new Dimension(550, 699));
    Credentials credentials = new Credentials("ruzalina15", "030703");
    login(credentials);

    // Начало сгенерированного кода из Katalon
    driver.get("https://www.zippyjot.com/home/");
    driver.findElement(By.name("notetitle")).click();
    driver.findElement(By.name("notetitle")).sendKeys("test");
    driver.findElement(By.id("textarea")).click();
    driver.findElement(By.id("textarea")).sendKeys("yewgtedwe");
//    driver.findElement(By.id("autosave")).click();
    driver.findElement(By.name("makeprivate")).click();
    driver.findElement(By.xpath("//body[@id='page-wrap']/div[2]/div/div[7]/button/span")).click();
    // Конец сгенерированного кода из Katalon
  }


  @Test
  public void testik() {
    driver.get("https://www.zippyjot.com/");
    driver.manage().window().setSize(new Dimension(550, 699));
    Credentials credentials = new Credentials("ruzalina15", "030703");
    login(credentials);
  }

}
