import appmanager.ApplicationManager;

public class TestBase {
    // Импорт класса ApplicationManager

    // Создаем переменную для хранения экземпляра ApplicationManager
    protected ApplicationManager applicationManager;

    public TestBase() {
        // В методе конструктора заменяем инициализацию ApplicationManager на вызов статического метода getInstance()
        applicationManager = ApplicationManager.getInstance();
    }

    // Метод для завершения работы теста, вызывающий метод quit() у ApplicationManager
    public void quit() {
        applicationManager.quit();
    }
}
