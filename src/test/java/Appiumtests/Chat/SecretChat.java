package Appiumtests.Chat;

import Appiumtests.TelegramTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SecretChat extends TelegramTest {

    public SecretChat() throws IOException {
    }

    private static final String friendToChat  = "Viet-kiemthu";

    @Test
    public void newSecretChat() {
        WebElement newChat = this.driver.findElementByAccessibilityId("New Message");
        newChat.click();
        this.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        WebElement newSecretChat = this.driver.findElementByXPath("//android.widget.FrameLayout[@text='New Secret Chat']");
        newSecretChat.click();
        this.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        WebElement selectFriendToChat = this.driver.findElementByXPath("//android.widget.TextView[@text=\"" + friendToChat + "\"]");
        selectFriendToChat.click();
        this.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
}
