import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.URL;


public class Ex3_CancelSearch {
    private AppiumDriver driver;

    @Before
    public void setup() throws Exception {
        DesiredCapabilities capabalities = new DesiredCapabilities();
        capabalities.setCapability("platformName","Android");
        capabalities.setCapability("deviceName","AndroidTestDevice");
        capabalities.setCapability("platformName","8.0");
        capabalities.setCapability("automationName","Appium");
        capabalities.setCapability("appPackage","org.wikipedia");
        capabalities.setCapability("appActivity",".main.MainActivity");
        capabalities.setCapability("app","/Users/zirina72/Desktop/JavaAppiumAutomation/apks/org.wikipedia.apk");

        driver = new AndroidDriver(new URL( "http://127.0.0.1:4723/wd/hub"), capabalities);
    }
    @After
    public void tearDown() {
        driver.quit();
    }



@Test
public void testCancelSearch() {
    waitForElementAndClick(By.id("org.wikipedia:id/search_container"), "Cant find search input",
            5) ;

    waitForElementAndSendKeys(By.id("org.wikipedia:id/search_src_text"),"Mobile", "Cant find search input",
            5);

    waitForElementPresent(By.id("org.wikipedia:id/search_results_list"), "Nothing was found by your request", 5);

    waitForElementAndClear(By.id("org.wikipedia:id/search_src_text"), "Search field is not found ", 5);

    waitForElementNotPresent(By.id("org.wikipedia:id/search_results_list"), "Search result list is still displaying", 5);

    waitForElementAndClick(By.id("org.wikipedia:id/search_close_btn"), "Close button is not found",
            5) ;

    waitForElementNotPresent(By.id("org.wikipedia:id/search_close_btn"), "Search toolbar still displays", 5);

    }








    private WebElement waitForElementPresent(By by, String error_message, long timeoutInSeconds){
        WebDriverWait wait =new WebDriverWait(driver,timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    private WebElement waitForElementAndClick(By by, String error_message, long timeoutInSeconds){
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.click();
        return element;
    }

    private WebElement waitForElementAndSendKeys(By by, String value, String error_message, long timeoutInSeconds){
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.sendKeys(value);
        return element;
    }

    private boolean waitForElementNotPresent(By by, String error_message, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message +"\n");
        //By by = By.id(id);
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    private WebElement waitForElementAndClear(By by, String error_message, long timeoutInSecond){
        WebElement element = waitForElementPresent(by, error_message, timeoutInSecond);
        element.clear();
        return element;
    }

}




























    /*private WebElement waitForElementPresent(By by, String error_message, long time_out_in_second) {
        WebDriverWait wait = new  WebDriverWait(driver, time_out_in_second);
        wait.withMessage(error_message + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    private WebElement waitForElementPresent(By by, String error_message) {
        return waitForElementPresent(by, error_message, 5);
    }


    private WebElement waitForElementAndClick(By by, String error_message, long time_out_in_second){
        WebElement element = waitForElementPresent(by, error_message, time_out_in_second);
        element.click();
        return element;
    }


    private WebElement waitForElementAndSendKeys(By by, String value, String error_message, long time_out_in_second){
        WebElement element = waitForElementPresent(by, error_message, time_out_in_second);
        element.sendKeys(value);
        return element;
    }



    private WebElement waitForElementAndClear(By by, String error_message, long time_out_in_second){
        WebElement element = waitForElementPresent(by, error_message, time_out_in_second);
        element.clear();
        return element;
    }

    private boolean waitForElementNotPresent(By by, String error_message, long time_out_in_second) {
        WebDriverWait wait = new WebDriverWait(driver, time_out_in_second);
        wait.withMessage(error_message + "\n");
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }


    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabalities = new DesiredCapabilities();
        capabalities.setCapability("platformName","Android");
        capabalities.setCapability("deviceName","AndroidTestDevice");
        capabalities.setCapability("platformName","8.0");
        capabalities.setCapability("automationName","Appium");
        capabalities.setCapability("appPackage","org.wikipedia");
        capabalities.setCapability("appActivity",".main.MainActivity");
        capabalities.setCapability("app","/Users/zirina72/Desktop/JavaAppiumAutomation/apks/org.wikipedia.apk");

        driver = new AndroidDriver(new URL( "http://127.0.0.1:4723/wd/hub"), capabalities);
        *//*driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        waitForElementAndClick(By.xpath("//*[contains(@text,'SKIP')]"),
                // waitForElementAndClick(By.id("org.wikipedia:id/fragment_onboarding_skip_button"),
                "Cannot find SKIP button",
                10);

        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);// Use the timeout when navigating to a webpage
*//*
    }

    @After
    public void tearDown() {
        driver.quit();

    }


    @Test
    public void Test1() {
        waitForElementAndClick(
                By.id("org.wikipedia:id/search_container"),
                //By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Cant find Search Wikipedia Input",
                10);


        waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search…')]"),
                "Java", "Cant find search input",
                15);


        waitForElementPresent(
                By.xpath("//*[@resource-id='org.wikipedia:id/search_results_list']//*[@text='Object-oriented programming language']"),
                "Cant find 'Object-oriented programming language' topic searcing by 'Java'",
                15);
    };

    @Test
    public void Test2(){
        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "cant find 'Search Wikipedia' by ID",
                10);


        waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search…')]"),
                "Java", "Cant find search input",
                15);


        waitForElementAndClick(
                By.id("org.wikipedia:id/search_close_btn"),
                "cant find X in search field",
                15
        );

        waitForElementAndClear(By.xpath("//*[@resource-id='org.wikipedia:id/search_src_text']"),
                "id is not found",
                15);

        waitForElementNotPresent(
                By.id("org.wikipedia:id/search_close_btn"),
                "X is still shown in search field",
                15
        );
    }*/
