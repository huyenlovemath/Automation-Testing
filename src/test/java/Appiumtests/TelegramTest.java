package Appiumtests;

import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

public class TelegramTest {
    private static String localDir = System.getProperty("user.dir");
    private static FileInputStream fileConfig;
    private static String environmentVariable;
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
    private static final String APP = localDir + "\\src\\app\\Telegram.apk";
    private static final String APPIUM = jsonEnvironmentVariable.getString("hostAppium");
    protected AndroidDriver driver;

    public TelegramTest() throws IOException {
    }

    @BeforeMethod
    public void SetUp() throws Exception {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", jsonEnvironmentVariable.getString("platformName"));
        capabilities.setCapability( "deviceName", jsonEnvironmentVariable.getString("deviceName"));
        capabilities.setCapability("app", APP);
        capabilities.setCapability("automationName", jsonEnvironmentVariable.getString("automationName"));
        capabilities.setCapability("appWaitActivity", jsonEnvironmentVariable.getString("appWaitActivity"));
        capabilities.setCapability("noReset", jsonEnvironmentVariable.getBoolean("noReset"));

        try {
            driver = new AndroidDriver(new URL(APPIUM), capabilities);
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
