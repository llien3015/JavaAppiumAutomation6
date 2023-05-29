package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.time.Duration;

public class CoreTestCase extends TestCase {

    private static final String PLATFORM_IOS = "ios";
    private static final String PLATFORM_ANDROID = "android";

    protected AppiumDriver driver;
    private static String AppiumURL = "http://127.0.0.1:4723";

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();

         DesiredCapabilities capabilities = this.getCapabilitiesByPlatformEnv();
        driver = new AndroidDriver(new URL(AppiumURL), capabilities);
        this.rotateScreenPortrate();
    }

    @Override
    protected void tearDown() throws Exception
    {
        driver.quit();

        super.tearDown();
    }
    protected void rotateScreenPortrate()
    {
        driver.rotate(ScreenOrientation.PORTRAIT);
    }
    protected void rotateScreenLandscape()
    {
        driver.rotate(ScreenOrientation.LANDSCAPE);
    }
     protected void backgroundApp(int seconds)
     {
         driver.runAppInBackground(Duration.ofSeconds(seconds));
     }

     private DesiredCapabilities getCapabilitiesByPlatformEnv() throws Exception
     {
         String platform = System.getenv("PLATFORM");
         DesiredCapabilities capabilities = new DesiredCapabilities();

         if (platform.equals(PLATFORM_ANDROID)) {
             capabilities.setCapability("platformName", "Android");
             capabilities.setCapability("deviceName", "AndroidTestDevice");
             capabilities.setCapability("platformVersion", "8.0");
             capabilities.setCapability("automationName", "Appium");
             capabilities.setCapability("appPackage", "org.wikipedia");
             capabilities.setCapability("appActivity", ".main.MainActivity");
             capabilities.setCapability("appium:automationName", "UiAutomator2");
             capabilities.setCapability("app", "/Users/admin/Desktop/JavaAppiumAutomation2/JavaAppiumAutomation2/apks/org.wikipedia.apk");
         } else if (platform.equals(PLATFORM_IOS)) {
             capabilities.setCapability("platformName", "iOS");
             capabilities.setCapability("deviceName", "iPhone 14");
             capabilities.setCapability("platformVersion", "16.4");
             capabilities.setCapability("app", "/Users/admin/Desktop/JavaAppiumAutomation iOS/JavaAppiumAutomation2/apks/Wikipedia690.app");
             capabilities.setCapability("appium:automationName", "XCUITest");
         } else {
             throw new Exception("Cannot get run platform from env variable. Platform value" + platform);
         }
         return capabilities;
     }

}
