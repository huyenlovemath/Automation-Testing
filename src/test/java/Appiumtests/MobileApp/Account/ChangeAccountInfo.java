package Appiumtests.MobileApp.Account;

import Appiumtests.MobileApp.MobileTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ChangeAccountInfo extends MobileTest {

    public ChangeAccountInfo() throws IOException {
    }

    private static final String firstNameTest = "NewFirstName";
    private static final String lastNameTest  = "NewLastName";
    private static String bioTest  = "New Bio";
    private static final int maxLengthBio = 70;

    @BeforeMethod
    private void openAccountInfo() {
        System.out.println("Open account details");
        WebElement navigationMenu = this.driver.findElementByAccessibilityId("Open navigation menu");
        navigationMenu.click();
        this.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        WebElement buttonAccountInfo = this.driver.findElementByXPath("//android.widget.FrameLayout[1]/android.view.View");
        buttonAccountInfo.click();
        this.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        this.driver.findElementByXPath("//android.widget.TextView[@text=\"Account\"]");
        this.driver.findElementByXPath("//android.widget.TextView[@text=\"Settings\"]");
    }

    @Test
    public void EditName() {
        System.out.println("Test edit name");

        WebElement buttonMoreInfo = this.driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"More options\"]/android.widget.ImageView");
        buttonMoreInfo.click();
        this.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        WebElement buttonEditName = this.driver.findElementByXPath("//android.widget.TextView[@text=\"Edit name\"]");
        buttonEditName.click();
        this.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        WebElement firstName = this.driver.findElementByXPath("//android.widget.EditText[1]");
        WebElement lastName = this.driver.findElementByXPath("//android.widget.EditText[2]");
        firstName.clear();
        lastName.clear();
        firstName.sendKeys(firstNameTest);
        lastName.sendKeys(lastNameTest);

        WebElement saveName = this.driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"Done\"]/android.widget.ImageView");
        saveName.click();
        this.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        WebElement fullName = this.driver.findElementByXPath("//android.widget.FrameLayout[1]/android.widget.TextView[1]");
        fullName.getText();
        Assert.assertEquals(fullName.getText(), firstNameTest + " " + lastNameTest);
    }

    @Test
    public void EditBio() {
        System.out.println("Test edit bio");

        WebElement bioTitle = this.driver.findElementByXPath("//android.widget.TextView[@text=\"Bio\"]");
        WebElement bioContent = this.driver.findElementByXPath("//android.widget.FrameLayout[5]");
        bioContent.click();
        this.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        WebElement bioEditContent = this.driver.findElementByXPath("//android.widget.EditText");
        WebElement saveBioContent = this.driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"Done\"]/android.widget.ImageView");
        if (bioTest.length() < maxLengthBio) {
            bioEditContent.clear();
            bioEditContent.sendKeys(bioTest);
        } else {
            Assert.fail("Bio content test is too long");
        }
        saveBioContent.click();
        this.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        WebElement bioContentNew = this.driver.findElementByXPath("//android.widget.FrameLayout[5]");
        this.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        Assert.assertEquals(bioContentNew.getText(),"Bio: " + bioTest);
    }

}