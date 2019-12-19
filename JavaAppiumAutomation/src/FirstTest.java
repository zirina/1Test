import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class FirstTest {
    private AppiumDriver driver;

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabalities = new DesiredCapabilities();
        capabalities.setCapability("platformName","Android");
        capabalities.setCapability("deviceName","AndroidTestDevice");
        capabalities.setCapability("platformName","8.0");
        capabalities.setCapability("automationName","Appium");
        capabalities.setCapability("appPackage","org.wikipedia");
        capabalities.setCapability("appActivity",".main.MainActivity");
        capabalities.setCapability("app","/Users/zirina72/Desktop/JavaAppiumAutomation/apks/org.wikipedia_30276_apps.evozi.com.apk");


        driver = new AndroidDriver(new URL( "http://127.0.0.1:4723/wd/hub"), capabalities);
    }

    @After
    public void tearDown() {
        driver.quit();

    }
 @Test
     public void firstTest() {
        System.out.println("First testt run ");
     }
}
