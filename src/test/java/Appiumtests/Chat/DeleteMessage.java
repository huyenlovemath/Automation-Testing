package Appiumtests.Chat;

import Appiumtests.TelegramTest;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DeleteMessage extends TelegramTest {
    public DeleteMessage() throws IOException {

    }

    @Test
    public void deleteChat() {
        int totalChats = this.driver.findElementsByClassName("android.view.ViewGroup").size();
        System.out.println("Total chat " + totalChats);
        WebElement chatForDelete = this.driver.findElementByXPath("//android.view.ViewGroup[1]");

        Actions actions = new Actions(this.driver);
        actions.clickAndHold(chatForDelete).perform();

        WebElement buttonMoveToTrash = this.driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"Delete\"]/android.widget.ImageView");
        buttonMoveToTrash.click();
        this.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        WebElement deleteChat = this.driver.findElementByXPath("//android.widget.TextView[@text=\"DELETE CHAT\"]");
        deleteChat.click();
        this.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        int totalChatsAfterDelete = this.driver.findElementsByClassName("android.view.ViewGroup").size();
        System.out.println("Total chat after delete " + totalChatsAfterDelete);

        Assert.assertEquals(totalChatsAfterDelete, totalChats-1);
    }

    @Test
    public void deleteMultiChats() {
        int totalChats = this.driver.findElementsByClassName("android.view.ViewGroup").size();
        System.out.println("Total chat " + totalChats);
        WebElement chatForDelete1 = this.driver.findElementByXPath("//android.view.ViewGroup[1]");
        WebElement chatForDelete2 = this.driver.findElementByXPath("//android.view.ViewGroup[2]");

        Actions actions = new Actions(this.driver);
        actions.clickAndHold(chatForDelete1).perform();
        chatForDelete2.click();
        this.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        WebElement buttonMoveToTrash = this.driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"Delete\"]/android.widget.ImageView");
        buttonMoveToTrash.click();
        this.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        WebElement deleteChat = this.driver.findElementByXPath("//android.widget.TextView[@text=\"DELETE\"]");
        deleteChat.click();
        this.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        int totalChatsAfterDelete = this.driver.findElementsByClassName("android.view.ViewGroup").size();
        System.out.println("Total chat after delete " + totalChatsAfterDelete);

        Assert.assertEquals(totalChatsAfterDelete, totalChats-2);
    }
}
