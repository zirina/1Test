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

public class Ex2_MethodCreation {
    private AppiumDriver driver;

    @Before
    public void seting() throws Exception {

        //The setCapability() method of the Desired Capabilities class can be used in mobile application automation, where the browser properties and the device properties can be set
        DesiredCapabilities capabalities = new DesiredCapabilities();
        capabalities.setCapability("platformName","Android");
        capabalities.setCapability("deviceName","AndroidTestDevice");
        capabalities.setCapability("platformVersion","8.0");
        capabalities.setCapability("automationName","Appium");
        capabalities.setCapability("appPackage","org.wikipedia");
        capabalities.setCapability("appActivity",".main.MainActivity");
        capabalities.setCapability("app","/Users/zirina72/Desktop/JavaAppiumAutomation/apks/org.wikipedia.apk");

        //Launching the application using appium server
        driver = new AndroidDriver(new URL( "http://127.0.0.1:4723/wd/hub"), capabalities);
    }

    @After
    public void tearDown() {
        driver.quit();
    }


    @Test
    public void searchTest() {
        waitForElementAndClick(By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Cant find 'Search Wikipedia'",
                5);

        WebElement st = waitForElementPresent(By.id("org.wikipedia:id/search_src_text"), "Cant find search input",
                15);

        String textSearch = st.getAttribute("text");
        Assert.assertEquals(
                "Text Search... is not found",
                "Search…",
                textSearch);
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

}
