package Appiumtests;

import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.IOUtils;
import org.aspectj.lang.annotation.Before;
import org.json.JSONObject;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumGridTest {
    private static String localDir = System.getProperty("user.dir");
    private static FileInputStream fileConfig;
    protected static String environmentVariable;
    static {
        try {
            fileConfig = new FileInputStream(localDir + "\\src\\test\\java\\.env");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static {
        try {
            environmentVariable = IOUtils.toString(fileConfig, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject jsonEnvironmentVariable = new JSONObject(environmentVariable);
    protected static final String APP = localDir + "\\src\\app\\Telegram.apk";
    protected static final String APPIUM = jsonEnvironmentVariable.getString("hostAppium");
    protected AndroidDriver driver;

    @AfterMethod
    public void TearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void openAccountInfo(AndroidDriver driver) {
        System.out.println("Open account details");
        WebElement navigationMenu = driver.findElementByAccessibilityId("Open navigation menu");
        navigationMenu.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        WebElement buttonAccountInfo = driver.findElementByXPath("//android.widget.FrameLayout[1]/android.view.View");
        buttonAccountInfo.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.findElementByXPath("//android.widget.TextView[@text=\"Account\"]");
        driver.findElementByXPath("//android.widget.TextView[@text=\"Settings\"]");
    }

}
