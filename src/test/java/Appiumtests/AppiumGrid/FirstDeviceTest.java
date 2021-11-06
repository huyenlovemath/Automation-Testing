package Appiumtests.AppiumGrid;

import Appiumtests.AppiumGridTest;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class FirstDeviceTest extends AppiumGridTest {
    @Test
    public void openAccountInfoFirst() {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", jsonEnvironmentVariable.getString("platformName"));
        capabilities.setCapability( "deviceName", jsonEnvironmentVariable.getString("deviceName"));
        capabilities.setCapability("app", APP);
        capabilities.setCapability("automationName", jsonEnvironmentVariable.getString("automationName"));
        capabilities.setCapability("appWaitActivity", jsonEnvironmentVariable.getString("appWaitActivity"));
        capabilities.setCapability("noReset", jsonEnvironmentVariable.getBoolean("noReset"));
        capabilities.setCapability("platformVersion", jsonEnvironmentVariable.getString("platformVersion"));

        try {
            driver = new AndroidDriver(new URL(APPIUM), capabilities);
            openAccountInfo(driver);
        } catch (WebDriverException | MalformedURLException e) {
            System.out.println("Cannot get your device");
            e.printStackTrace();
        }
    }
}
