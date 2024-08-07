package OrgExample;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RozetkaMainPage {
    WebDriver driver;

    @FindBy(xpath = "/html/body/rz-app-root/div/div/rz-header/rz-main-header/header/div/div/div/rz-search-suggest/form/div/div[1]/input")
    private static WebElement searchPins;

    @FindBy(xpath = "/html/body/rz-app-root/div/div/rz-search/rz-catalog/div/div[2]/section/rz-grid/ul/li[1]/rz-catalog-tile/app-goods-tile-default/div/div[2]/div[1]/div[4]/div[2]/rz-buy-button/button")
    private static WebElement ddToBasket;

    @FindBy(xpath = "/html/body/rz-app-root/div/div/rz-search/rz-catalog/div/div[2]/section/rz-grid/ul/li[1]/rz-catalog-tile/app-goods-tile-default/div/div[2]/div[1]/rz-button-product-page[2]/a/span")
    private static WebElement TextToCompareElement;


//    public RozetkaMainPage(WebDriver driver) {
//        this.driver = driver;
//        PageFactory.initElements( driver, this);
//    }
    public RozetkaMainPage() {
        this.driver = SingletonDriver.getInstance().getDriver();
        PageFactory.initElements(SingletonDriver.getInstance().getDriver(), this);
    }

    public static void rozetkaSearch(WebDriver driver) {
        searchPins.click();
        searchPins.sendKeys("ручки");
        searchPins.sendKeys(Keys.ENTER);
    }

    public static void AddToBasket(WebDriver driver) {
        Actions builder = new Actions(driver);
        new Actions(driver)
                .scrollToElement(ddToBasket)
                .perform();
        ddToBasket.click();
    }
    public static String texttocompareelement (WebDriver driver) {
        return TextToCompareElement.getText();
    }
}
