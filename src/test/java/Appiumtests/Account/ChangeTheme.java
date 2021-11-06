package Appiumtests.Account;

import Appiumtests.MobileTest;
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
    @Test
    public void ChangeUserTheme() {
        System.out.println(" Start Change Theme test");

        WebElement Menu = driver.findElementByXPath("//android.widget.ImageView[@content-desc='Open navigation menu']");
        Menu.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement changeTheme = driver.findElementByXPath("//android.widget.ImageView[@text='Switch to day theme']");
        changeTheme.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }
}
