package Appiumtests.MobileApp.Chat;

import Appiumtests.MobileApp.MobileTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class NormalChat extends MobileTest {
    public NormalChat() throws IOException {
    }

    @Test
    public void inHomePage() {
        System.out.println("Home page telegram");

        WebElement account = this.driver.findElementByClassName("androidx.recyclerview.widget.RecyclerView");
        account.click();
        this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void FindUserAndCheckInbox() {
        System.out.println(" Start Find User test");

        WebElement searchButton = driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Search']");
        searchButton.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        WebElement edit = driver.findElementByXPath("//android.widget.EditText[@text='Search']");
        edit.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        edit.sendKeys("Việt");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        WebElement chooseUser = driver.findElementByXPath("//android.view.ViewGroup[@index='0']");
        chooseUser.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }

    @Test
    public void SendMessage() {
        System.out.println(" Start Send Message test");

        String messageToSend = "haha";
        WebElement choosePartner = driver.findElementByXPath("//android.view.ViewGroup[@index='0']");
        choosePartner.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement edit = driver.findElementByXPath("//android.widget.EditText[@index='1']");
        edit.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        edit.sendKeys(messageToSend);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement sendButton = driver.findElementByXPath("//android.view.View[@content-desc='Send']");
        sendButton.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        List<WebElement> message = driver.findElementsByXPath("//androidx.recyclerview.widget.RecyclerView/*");
        WebElement lastMessage = message.get(message.size() - 1);
        String lastMessageString = lastMessage.getAttribute ("content-desc").toString();
        Assert.assertEquals(lastMessageString.substring(0, messageToSend.length()),messageToSend);
    }

    @Test
    public void SendEmoji() {
        System.out.println(" Start Send Message test");

        String emojiToSend = "\uD83D\uDE18";
        WebElement choosePartner = driver.findElementByXPath("//android.view.ViewGroup[@index='0']");
        choosePartner.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement emojiButton = driver.findElementByXPath("//android.widget.ImageView[@content-desc='Emoji, stickers, and GIFs']");
        emojiButton.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement emojisButton = driver.findElementByXPath("//android.widget.ImageView[@content-desc=\"Emoji\"]");
        emojisButton.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement emoji = driver.findElementByXPath("//android.widget.ImageView[@content-desc=\"\uD83D\uDE18\"]");
        emoji.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement sendButton = driver.findElementByXPath("//android.view.View[@content-desc='Send']");
        sendButton.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.navigate().back();
        List<WebElement> message = driver.findElementsByXPath("//androidx.recyclerview.widget.RecyclerView/*");
        WebElement lastMessage = message.get(message.size() - 1);
        String lastMessageString = lastMessage.getAttribute ("content-desc").toString();
        Assert.assertEquals(lastMessageString.substring(0, emojiToSend.length()),emojiToSend);
    }

    @Test
    public void SendStiker() {
        System.out.println(" Start Send Message test");

        String stickerToSend ="\uD83D\uDE02 Sticker";
        WebElement choosePartner = driver.findElementByXPath("//android.view.ViewGroup[@index='0']");
        choosePartner.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement emojiButton = driver.findElementByXPath("//android.widget.ImageView[@content-desc='Emoji, stickers, and GIFs']");
        emojiButton.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement stickerButton = driver.findElementByXPath("//android.widget.ImageView[@content-desc=\"Stickers\"]");
        stickerButton.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement stiker = driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"\uD83D\uDE02 Sticker\"]");
        stiker.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.navigate().back();
        List<WebElement> message = driver.findElementsByXPath("//androidx.recyclerview.widget.RecyclerView/*");
        WebElement lastMessage = message.get(message.size() - 1);
        String lastMessageString = lastMessage.getAttribute ("content-desc").toString();
        Assert.assertEquals(lastMessageString.substring(0, stickerToSend.length()),stickerToSend);
    }

    @Test
    public void ShareLocationMessage() {
        System.out.println(" Start Share Location test");

        String locationString ="Location";
        WebElement choosePartner = driver.findElementByXPath("//android.view.ViewGroup[@index='0']");
        choosePartner.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement chooseLocation = driver.findElementByXPath("//android.widget.ImageView[@content-desc='Attach media']");
        chooseLocation.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        WebElement sendLocation = driver.findElementByXPath("//android.widget.TextView[@text='Location']");
        sendLocation.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        WebElement SEND = driver.findElementByXPath("//android.widget.TextView[@text='Send My Current Location']");
        SEND.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }


    @Test
    public void SendImage() {
        System.out.println(" Start Send Image test");

        WebElement choosePartner = driver.findElementByXPath("//android.view.ViewGroup[@index='0']");
        choosePartner.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement chooseImage = driver.findElementByXPath("//android.widget.ImageView[@content-desc='Attach media']");
        chooseImage.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        WebElement sendImage = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View");
        sendImage.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        WebElement sendButton = driver.findElementByXPath("//android.widget.ImageView[@content-desc='Send']");
        sendButton.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }

    @Test
    public void CropBeforeSendImage() {
        System.out.println(" Start Crop Before Send Image test");

        WebElement choosePartner = driver.findElementByXPath("//android.view.ViewGroup[@index='0']");
        choosePartner.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement chooseImage = driver.findElementByXPath("//android.widget.ImageView[@content-desc='Attach media']");
        chooseImage.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        WebElement sendImage = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View");
        sendImage.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        WebElement cropButton = driver.findElementByXPath("//android.widget.ImageView[@content-desc='Crop image']");
        cropButton.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        WebElement rotate = driver.findElementByXPath("//android.widget.ImageView[@content-desc='Rotate']");
        rotate.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        WebElement crop = driver.findElementByXPath("//android.widget.TextView[@text='CROP']");
        crop.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        WebElement sendButton = driver.findElementByXPath("//android.widget.ImageView[@content-desc='Send']");
        sendButton.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }



}
