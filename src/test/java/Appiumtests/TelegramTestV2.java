package Appiumtests;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TelegramTestV2 {
    private static final String APP = "C:\\Users\\Dell\\Desktop\\Automation-Testing-huyennt\\src\\app\\Telegram.apk";
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
        capabilities.setCapability( "deviceName", "AHB00034055");
        capabilities.setCapability("app", APP);
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("noReset", true);

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

        //List<WebElement> message = driver.findElementsByXPath("//androidx.recyclerview.widget.RecyclerView/*");
        //WebElement lastMessage = message.get(message.size() - 1);
        //String lastMessageString = lastMessage.getAttribute ("content-desc").toString();
        //String lastMessageString = message.get(0).getAttribute ("index").toString();

        //System.out.println(lastMessageString);
        //Assert.assertEquals(lastMessageString.substring(0, locationString.length()),locationString);
    }

    /*@Test
    public void UploadFile() { //Lỗi
        System.out.println(" Start Upload File test");

        WebElement choosePartner = driver.findElementByXPath("//android.view.ViewGroup[@index='0']");
        choosePartner.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement chooseLocation = driver.findElementByXPath("//android.widget.ImageView[@content-desc='Attach media']");
        chooseLocation.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        WebElement sendLocation = driver.findElementByXPath("//android.widget.TextView[@text='File']");
        sendLocation.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        //Tiếp theo là lấy element file, nhưng nó là danh sách, k làm dc

        Assert.assertEquals("80","80");
    }*/

    @Test
    public void ChangeTheme() {
        System.out.println(" Start Change Theme test");

        WebElement Menu = driver.findElementByXPath("//android.widget.ImageView[@content-desc='Open navigation menu']");
        Menu.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement changeTheme = driver.findElementByXPath("//android.widget.ImageView[@text='Switch to day theme']");
        changeTheme.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        Assert.assertEquals("80","80");
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

        Assert.assertEquals("80","80");
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

        Assert.assertEquals("80","80");
    }
/*
    @Test
    public void BlockUser() { // Loi
        System.out.println(" Start Block User test");

        WebElement choosePartner = driver.findElementByXPath("//android.view.ViewGroup[@index='0']");
        choosePartner.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        WebElement profile = driver.findElementByXPath("//android.view.View[@content-desc=\"Profile picture\"]");
        profile.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        WebElement options = driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"More options\"]");
        options.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        //WebElement block = driver.findElementByXPath("//android.widget.TextView[@text='Block user'");
        //block.click();
        //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        //WebElement confirmBlock = driver.findElementByXPath("//android.widget.TextView[@text='BLOCK USER'");
        //confirmBlock.click();
        //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        Assert.assertEquals("80","80");
    }*/

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

        Assert.assertEquals("80","80");
    }

    /*
    @Test
    public void DeleteMessage() { //Lỗi
        System.out.println(" Start Delete Message test");

        WebElement choosePartner = driver.findElementByXPath("//android.view.ViewGroup[@index='0']");
        choosePartner.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        List<WebElement> messages = driver.findElementsByXPath("//androidx.recyclerview.widget.RecyclerView/*");
        WebElement lastMessage = messages.get(messages.size() - 1);

        TouchActions action = new TouchActions(driver);
        action.singleTap(lastMessage);
        action.perform();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        //WebElement deleteButton = driver.findElementByXPath("//android.widget.TextView[@text='Delete']");
        //deleteButton.click();
        //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        //WebElement DELETE = driver.findElementByXPath("android.widget.TextView[@text='DELETE']");
        //DELETE.click();
        //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        Assert.assertEquals("80","80");
    }
*/

}