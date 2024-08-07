package OrgExample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SingletonDriver {
    private static SingletonDriver INSTANCE;
    private final WebDriver driver;
    private SingletonDriver() {
        driver = new ChromeDriver();
    }
    public static SingletonDriver getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SingletonDriver();
        }
        return INSTANCE;
    }
    public WebDriver getDriver() {
        return driver;
    }
}
