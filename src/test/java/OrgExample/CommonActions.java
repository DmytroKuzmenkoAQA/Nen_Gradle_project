package OrgExample;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class CommonActions {
    WebDriver driver;

    public void commonConfiguration() {
        driver = SingletonDriver.getInstance().getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static void scrollDown (WebDriver driver, int y) {
        int windowHeight = driver.manage().window().getSize().getHeight();
        int deltaY = windowHeight/100 * y;
        new Actions(driver)
                .scrollByAmount(0, deltaY)
                .perform();
    }
    public static void scrollUp (WebDriver driver, int z) {
        int windowHeight = driver.manage().window().getSize().getHeight();
        int deltaY = -(windowHeight/100 * z);
        new Actions(driver)
                .scrollByAmount(0, deltaY)
                .perform();
    }
}
