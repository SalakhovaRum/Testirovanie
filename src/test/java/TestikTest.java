import org.junit.Test;
import org.openqa.selenium.Dimension;


public class TestikTest extends TestBase {

  @Test
  public void testik() {
    driver.get("https://www.zippyjot.com/");
    driver.manage().window().setSize(new Dimension(550, 699));
    Credentials credentials = new Credentials("ruzalina15", "030703");
    login(credentials);
  }
}
