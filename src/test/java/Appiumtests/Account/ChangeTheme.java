package Appiumtests.Account;

import Appiumtests.MobileTest;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ChangeTheme extends MobileTest {
    public ChangeTheme() throws IOException {
    }

    private static final String dayTheme = "//android.widget.ImageView[@text='Switch to night theme']";
    private static final String nightTheme  = "//android.widget.ImageView[@text='Switch to day theme']";
    @Test
    public void ChangeUserTheme() {
        System.out.println(" Start Change Theme test");

        WebElement Menu = driver.findElementByXPath("//android.widget.ImageView[@content-desc='Open navigation menu']");
        Menu.click();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        WebElement changeTheme = driver.findElementByXPath(dayTheme);
        if (changeTheme.isDisplayed()) {
            changeTheme.click();
        } else {
            driver.findElementByXPath(nightTheme).click();
        }

    }
}
