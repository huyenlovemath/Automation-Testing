package Appiumtests.DesktopApp;

import io.appium.java_client.AppiumDriver;
import org.testng.annotations.Test;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TelegramTestWindow extends DesktopTest{

    public TelegramTestWindow() throws IOException {
    }

    @Test
    public void TestChangeTheme() {

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement Menu = driver.findElementByXPath("/Window/Group[2]/Group/Group/Group[2]/Group[1]/Group");
        Menu.click();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement ChangeTheme = driver.findElementByXPath("/Window/Group[2]/Group/Group[2]/Group[2]/Group[4]/Group/Group/Group[3]/Group[5]");
        ChangeTheme.click();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }
}