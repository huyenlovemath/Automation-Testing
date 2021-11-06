package Appiumtests.DesktopApp;

import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TelegramTestWindow {

    private AppiumDriver<WebElement> driver;

    @BeforeMethod
    public void setUp() throws IOException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Windows");
        caps.setCapability("platformVersion", "10");
        caps.setCapability("deviceName", "WindowsPC");
        caps.setCapability("app", "C:\\Users\\Dell\\AppData\\Roaming\\Telegram Desktop\\Telegram.exe");

        driver = new AppiumDriver<>(new URL("http://localhost:4723/wd/hub"), caps);
    }

    @AfterMethod
    public void tearDown() {
        try {
            driver.quit();
        } catch (Exception ign) {}
    }

    @Test
    public void TestChangeTheme() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement Menu = driver.findElementByXPath("/Window/Group[2]/Group/Group/Group[2]/Group[1]/Group");
        Menu.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        //WebElement ChangeTheme = driver.findElementById("42.1443560.4.-2147482548");
        WebElement ChangeTheme = driver.findElementByXPath("/Window/Group[2]/Group/Group[2]/Group[2]/Group[4]/Group/Group/Group[3]/Group[5]");
        ChangeTheme.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assert.assertEquals("80","80");
    }
}