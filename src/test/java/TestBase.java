import appmanager.ApplicationManager;

public class TestBase {
    protected ApplicationManager applicationManager;

    public TestBase() {
        applicationManager = new ApplicationManager();
    }

    public void quit() {
        applicationManager.quit();
    }
}

