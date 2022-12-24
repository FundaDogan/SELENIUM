package Practice.Day02;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Q03 extends TestBase {
    /*
    Given
        Go to "http://webdriveruniversity.com/Popup-Alerts/index.html"
    When
        Click "CLICK ME" of JavaScript Alert
    And
        Get the pop-up text
    Then
        Verify that message is "I am an alert box!"
    When
        Accept pop-up
     */

    @Test
    public void test() {
        driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");

        driver.findElement(By.id("button1")).click();

        String text = driver.switchTo().alert().getText();

        Assert.assertEquals("I am an alert box!",text);

        driver.switchTo().alert().accept();
    }
}
