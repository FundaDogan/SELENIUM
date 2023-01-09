package Practice.Day05;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.IOException;

public class Q02 extends TestBase {

    @Test
    public void test() throws IOException {
//        Given
//        Go to "http://webdriveruniversity.com/Popup-Alerts/index.html"

        driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");
        takeScreenshotOfPage();

//        When
//        Click on Ajax Loader
        driver.findElement(By.xpath("//a[text()='CLICK ME!']")).click();
        takeScreenshotOfPage();

//        And
//        Click on "Click Me!" button
        driver.findElement(By.xpath("//p[text()='CLICK ME!']")).click();

        waitForVisibility(By.id("button1"),10);

        takeScreenshotOfPage();

//                Then
//        Assert that button is clicked
        waitForVisibility(driver.findElement(By.xpath("//*[text()='Well Done For Waiting....!!!']")),10);

        WebElement text = driver.findElement(By.xpath("//*[text()='Well Done For Waiting....!!!']"));

        takeScreenshotOfPage();

        Assert.assertTrue(text.isDisplayed());

//                And
//        Take screenshot after each step
    }
}
