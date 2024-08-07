package OrgExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasketOverlay {
    WebDriver driver;

    @FindBy(xpath = "//*[@class='badge ng-star-inserted']")
    private static WebElement basketBadge;

    @FindBy(xpath = "/html/body/rz-app-root/div/div/rz-header/rz-main-header/header/div/div/ul/li[7]/rz-header-cart/button")
    private static WebElement basket;

    @FindBy(xpath = "/html/body/rz-app-root/rz-single-modal-window/div[3]/div[2]/rz-shopping-cart/div/rz-cart-purchases/ul/li/rz-cart-product/div/div[1]/div[2]")
    private static WebElement textInBasket;


    public BasketOverlay(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements( driver, this);
    }
    public BasketOverlay() {
        this.driver = SingletonDriver.getInstance().getDriver();
        PageFactory.initElements(SingletonDriver.getInstance().getDriver(), this);
    }

    public static void Basket (WebDriver driver) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(basketBadge)).isDisplayed();
        Thread.sleep(10000);
        basket.click();
    }

    public static String textinbasket (WebDriver driver) {
        return textInBasket.getText();
    }
}
