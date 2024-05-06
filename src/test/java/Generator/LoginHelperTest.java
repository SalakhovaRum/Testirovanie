package Generator;

import appmanager.ApplicationManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class LoginHelperTest {

    private ApplicationManager applicationManager;
    private LoginHelper loginHelper;
    private String username;
    private String password;

    @Before
    public void setUp() {
        applicationManager = ApplicationManager.getInstance();
        WebDriver driver = applicationManager.getDriver();
        loginHelper = new LoginHelper(applicationManager, driver);
        loginHelper.openLoginPage();

        // Чтение данных пользователя из XML
        readUserDataFromXML();
    }

    private void readUserDataFromXML() {
        try {
            File file = new File("testdata.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("testdata");
            Node node = nodeList.item(0);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                username = element.getElementsByTagName("username").item(0).getTextContent();
                password = element.getElementsByTagName("password").item(0).getTextContent();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testLogin() {
        loginHelper.login(username, password);

        // Получаем экземпляр WebDriver из LoginHelper
        WebDriver driver = loginHelper.getDriver();

        // Утверждение: Проверяем, что после входа появляется кнопка "Sign Out"
        boolean isSignedIn = driver.findElement(By.linkText("Sign Out")).isDisplayed();
        Assert.assertTrue("Пользователь не вошел в систему!", isSignedIn);

        // Выполняем необходимые действия после входа
        driver.findElement(By.linkText("Sign Out")).click();
    }
}
