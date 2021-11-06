package Appiumtests.AppiumGrid;

import Appiumtests.AppiumGridTest;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class SecondDeviceTest extends AppiumGridTest {

    @Test
    public void openAccountInfoSecond() {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", jsonEnvironmentVariable.getString("platformName2"));
        capabilities.setCapability( "deviceName", jsonEnvironmentVariable.getString("deviceName2"));
        capabilities.setCapability("app", APP);
        capabilities.setCapability("automationName", jsonEnvironmentVariable.getString("automationName"));
        capabilities.setCapability("appWaitActivity", jsonEnvironmentVariable.getString("appWaitActivity"));
        capabilities.setCapability("noReset", jsonEnvironmentVariable.getBoolean("noReset"));
        capabilities.setCapability("platformVersion", jsonEnvironmentVariable.getString("platformVersion2"));

        try {
            driver = new AndroidDriver(new URL(APPIUM), capabilities);
            openAccountInfo(driver);
        } catch (WebDriverException | MalformedURLException e) {
            System.out.println("Cannot get your device");
            e.printStackTrace();
        }
    }
}
