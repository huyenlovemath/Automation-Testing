package Appiumtests.DesktopApp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.net.URL;

public class DesktopTest {
    //private static String localDir = System.getProperty("user.dir");
    private static final String APP = "C:\\Users\\Dell\\AppData\\Roaming\\Telegram Desktop\\Telegram.exe";
    protected AppiumDriver<WebElement> driver;
    private static final String APPIUM = "http://localhost:4723/wd/hub";

    public DesktopTest() throws IOException {
    }

    @BeforeMethod
    public void SetUp() throws Exception {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Windows");
        caps.setCapability("platformVersion", "10");
        caps.setCapability("deviceName", "WindowsPC");
        caps.setCapability("app", APP);

        try {
            driver = new AppiumDriver<>(new URL(APPIUM), caps);
        } catch (WebDriverException e) {
            System.out.println("Cannot get your device");
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void TearDown() {
        if (driver != null) {
            driver.quit();
        }

    }
}
