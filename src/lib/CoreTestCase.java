package lib;

import io.appium.java_client.AppiumDriver;
import junit.framework.TestCase;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.time.Duration;

public class CoreTestCase extends TestCase {

    protected AppiumDriver driver;
    protected Platform Platform;

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        this.Platform = new Platform();
        driver = this.Platform.getDriver();
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


}
