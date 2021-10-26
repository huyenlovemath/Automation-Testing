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


public class SwagLabAndroidLoginTest {

    //change path to app
    private static final String APP = "D:\\Studies\\2021_2022_HK1\\KiemThu\\BTL\\SetUp\\app\\Android.SauceLabs.Mobile.Sample.app.2.7.1.apk";
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
        capabilities.setCapability("appWaitActivity", "com.swaglabsmobileapp.MainActivity");
        capabilities.setCapability("noReset", "true");

        driver = new AndroidDriver(new URL(APPIUM), capabilities);


    }

    @AfterMethod
    public void TearDown() {
        if (driver != null) {
            driver.quit();
        }

    }



    @Test
    public void loginToSwagLabsTestValid() throws Exception {
        System.out.println("Sauce - Start loginToSwagLabsTestValid test");

        login("standard_user", "secret_sauce");

        // Verification

        Assert.assertTrue(isOnProductsPage());
    }

    @Test
    public void loginTestValidProblem() throws Exception {

        System.out.println("Sauce - Start loginTestValidProblem test");

        login("problem_user", "secret_sauce");

        // Verification - we on Product page
        Assert.assertTrue(isOnProductsPage());
    }


    public void login(String user, String pass) {

        // WebDriverWait wait = new WebDriverWait(driver, 5);
        final WebElement usernameEdit = new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated( new MobileBy.ByAccessibilityId(usernameID)));

        usernameEdit.click();
        usernameEdit.sendKeys(user);

        WebElement passwordEdit = driver.findElementByAccessibilityId(passwordID);
        passwordEdit.click();
        passwordEdit.sendKeys(pass);

        WebElement submitButton = driver.findElementByAccessibilityId(submitButtonID);
        submitButton.click();


    }

    public boolean isOnProductsPage() {
        //Create an instance of a Appium explicit wait so that we can dynamically wait for an element
        WebDriverWait wait = new WebDriverWait(driver, 5);

        //wait for the product field to be visible and store that element into a variable
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(ProductTitle));
        } catch (TimeoutException e){
            System.out.println("*** Timed out waiting for product page to load.");
            return false;
        }
        return true;
    }



}
