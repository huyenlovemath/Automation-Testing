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

public class FoodAppLogin {

    //change path to app
    private static final String APP = "D:\\Studies\\2021_2022_HK1\\KiemThu\\BTL\\AutomationTest\\src\\app\\FooodApp.apk";
    private static final String APPIUM = "http://localhost:4723/wd/hub";

    private AndroidDriver driver;


    By GetStartPage = By.name("Get Started");
    By SignInPage = By.name("Welcome!");
    By MainPage = By.name("TIME TO EAT");
    By getStartButton = By.className("android.view.View");
    By emailEdit = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.EditText");
    By passwordEdit = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.EditText");
    By signInButton = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.View");

    By forgotPwdButton = By.name("Forgot password?");

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
    public void loginTestInValidEmail() {
        System.out.println("Sauce - Start loginTestValidProblem test");

        signInAction("hoangviet00", "password");

        // Verification - we on Product page
        Assert.assertFalse(isOnMainPage());
    }


    @Test
    public void loginTestValid() {
        System.out.println("Sauce - Start loginTestValidProblem test");

        signInAction("hoangviet000114@gmail.com", "password");

        // Verification - we on Product page
        Assert.assertTrue(isOnMainPage());
    }


    public void signInAction(String email, String pass) {

        // WebDriverWait wait = new WebDriverWait(driver, 5);
        final WebElement startButton = new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(getStartButton));

        startButton.click();

        WebElement emailTextEdit = new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(emailEdit));

        emailTextEdit.sendKeys(email);
        WebElement passwordTextEdit = driver.findElement(passwordEdit);
        passwordTextEdit.click();
        passwordTextEdit.sendKeys(pass);

        WebElement signIn = driver.findElementById("00000000-0000-06f7-ffff-ffff00000036");
        signIn.click();


    }

    public boolean isOnSignInPage() {
        return driver.findElement(SignInPage).isDisplayed();
    }

    public boolean isOnMainPage() {
        return driver.findElement(MainPage).isDisplayed();
    }
    public boolean isOnGetStartPage() {

        System.out.println("Check on get start page");

       return driver.findElement(getStartButton).isDisplayed();

    }
}
