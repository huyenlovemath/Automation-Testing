package Appiumtests;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


public class CalculatorTest {

    private static final String APP = "D:\\Studies\\2021_2022_HK1\\KiemThu\\BTL\\AutomationTest\\src\\app\\Calculator_v7.8.apk";
    private static final String APPIUM = "http://localhost:4723/wd/hub";

    private AndroidDriver driver;

    String usernameID = "test-Username";
    String passwordID = "test-Password";
    String submitButtonID = "test-LOGIN";
    By ProductTitle = By.xpath("//android.widget.TextView[@text='PRODUCTS']");

    @BeforeMethod
    public void SetUp() throws Exception {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "ANDROID");
        capabilities.setCapability( "deviceName", "emulator-5554");
        capabilities.setCapability("app", APP);
        capabilities.setCapability("automationName", "UiAutomator2");
        //capabilities.setCapability("appWaitActivity", "com.swaglabsmobileapp.MainActivity");

        driver = new AndroidDriver(new URL(APPIUM), capabilities);


    }

    @AfterMethod
    public void TearDown() {
        if (driver != null) {
            driver.quit();
        }

    }



    @Test
    public void PlusTwoNumbers() {
        System.out.println(" Start Calculator PlusTwoNumbers test");

        WebElement digit9 = driver.findElementById("com.google.android.calculator:id/digit_9");
        WebElement plus = driver.findElementByAccessibilityId("plus");
        WebElement digit7 = driver.findElementById("com.google.android.calculator:id/digit_7");
        WebElement digit1 = driver.findElementById("com.google.android.calculator:id/digit_1");

        digit9.click();
        plus.click();
        digit7.click();
        digit1.click();

        WebElement sum = driver.findElementById("com.google.android.calculator:id/result_preview");

        // Verification
        Assert.assertEquals(sum.getText(),"80");
    }

    @Test
    public void MinusTwoNumbers() {
        System.out.println(" Start Calculator MinusTwoNumbers test");

        WebElement digit9 = driver.findElementById("com.google.android.calculator:id/digit_9");
        WebElement digit7 = driver.findElementById("com.google.android.calculator:id/digit_7");
        WebElement digit8 = driver.findElementById("com.google.android.calculator:id/digit_8");
        WebElement minus = driver.findElementByAccessibilityId("minus");

        digit9.click();

        minus.click();
        digit7.click();
        digit8.click();

        String result = driver.findElementById("com.google.android.calculator:id/result_preview").getText();

        // Verification
        Assert.assertEquals(result,"−69");

    }

}
