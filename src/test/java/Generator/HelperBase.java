package Generator;

import appmanager.ApplicationManager;
import org.openqa.selenium.WebDriver;

public class HelperBase {
    protected WebDriver driver;
    protected ApplicationManager applicationManager;

    public HelperBase(ApplicationManager applicationManager, WebDriver driver) {
        this.applicationManager = applicationManager;
        this.driver = driver;
    }
}
