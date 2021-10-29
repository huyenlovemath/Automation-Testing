package Appiumtests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class FirstTest extends TelegramTest {
    public FirstTest() throws IOException {
    }

    @Test
    public void home() {
        System.out.println("Home page telegram");

        WebElement account = this.driver.findElementByClassName("androidx.recyclerview.widget.RecyclerView");
        account.click();
        this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
}
