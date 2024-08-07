package OrgExample;

import org.example.User;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static OrgExample.TestUserPractice.driver;


public class pageGoogle {
    WebDriver driver;



    @FindBy(xpath = "//*[@id=\"APjFqb\"]")
    public static WebElement searchField;

    @FindBy(xpath = "//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div/div[1]/div/span/a/h3")
    private static WebElement rozetkaSite;

    @FindBy(xpath = "//*[@id=\"L2AGLb\"]/div")
    private static WebElement cockie;

    // Додати такий самий для сторін Rozetka, Basket;
    public pageGoogle(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements( driver, this);
    }
    public pageGoogle() {
        this.driver = SingletonDriver.getInstance().getDriver();
        PageFactory.initElements(SingletonDriver.getInstance().getDriver(), this);
    }


    public static void googleSearch(WebDriver driver) {
        driver.get("https://www.google.com/");
//        if (cockie.isDisplayed()) cockie.click();
        searchField.sendKeys("rozetka com ua");
        searchField.sendKeys(Keys.ENTER);
        rozetkaSite.click();
    }
}