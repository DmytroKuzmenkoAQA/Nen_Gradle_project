package OrgExample;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.asm.Advice;
import org.example.User;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// import org.openqa.selenium.support.ui.;



import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.openqa.selenium.By.*;

//import static org.junit.jupiter.api.Assertions.assertAll;
//import static org.junit.jupiter.api.Assertions.assertEquals;


class TestUserPractice {
    User userOne;
    static WebDriver driver;
    static CommonActions ca = new CommonActions();


    @BeforeAll
    public static void setUpGeneral() {
    }

    @BeforeEach
    void setUp() {
        userOne = new User("User One", 25);
    }

    @AfterEach
    void tearDown() {
        //driver.quit();
    }

    @Test
    void getAge() {
//          assertEquals(25, userOne.getAge(), "Age is not correct");
//          assertEquals("User One", userOne.getName(), "Name is not correct");
        assertAll(
                () -> assertEquals(25, userOne.getAge(), "Age is not correct"),
                () -> assertEquals("User One", userOne.getName(), "Name is not correct")
        );
    }

//    @Test
//    void firstsearch() {
//        String textexpect = "XPath Syntax";
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.get("https://www.google.com/");
//        WebElement searchField = driver.findElement(new By.ById("APjFqb"));
//        searchField.click();
//        searchField.sendKeys(textexpect);
//        searchField.sendKeys(Keys.ENTER);
//        WebElement searchResult = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/div/div/span/a/h3"));
//        Assertions.assertEquals(textexpect, searchResult.getText(), "Text are not equal!");
//        System.out.println("Test is done");
//        //WebElement wait = new WebDriver(driver, Duration.ofSeconds(5));
//        //WebElement element = wait.until(ExpectedCondition.elementToBeClickable(By.id("elementId")));
//
//        driver.quit();
//    }

    @Test
    void testrozetka() throws InterruptedException {
        //ca.commonConfiguration();
        driver = SingletonDriver.getInstance().getDriver();

        pageGoogle pageGoogle = new pageGoogle();
        RozetkaMainPage RozetkaMainPage = new RozetkaMainPage();
        BasketOverlay BasketOverlay = new BasketOverlay();


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        pageGoogle.googleSearch(driver);
        driver.manage().timeouts().getPageLoadTimeout();
        RozetkaMainPage.rozetkaSearch(driver);
        RozetkaMainPage.texttocompareelement(driver);

        RozetkaMainPage.AddToBasket(driver);
        BasketOverlay.Basket(driver);
        BasketOverlay.textinbasket(driver);
        Assertions.assertEquals(RozetkaMainPage.texttocompareelement(driver), BasketOverlay.textinbasket(driver), "Text is not equal");

        driver.quit();
    }
}
