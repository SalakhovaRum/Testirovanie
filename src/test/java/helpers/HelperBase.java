package helpers;

import org.openqa.selenium.WebDriver;
import appmanager.ApplicationManager;

public class HelperBase {
    protected WebDriver driver;
    protected ApplicationManager applicationManager;

    public HelperBase(ApplicationManager applicationManager, WebDriver driver) {
        this.applicationManager = applicationManager;
        this.driver = driver;
    }

    // Другие общие методы, которые могут быть использованы в различных хелперах
}
