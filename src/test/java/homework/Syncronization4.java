package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Syncronization4 extends TestBase {
    @Test
    public void isEnabled() {

//        Go to https://the-internet.herokuapp.com/dynamic_controls
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
//        Click enable Button
        driver.findElement(By.xpath("//button[text()='Enable']")).click();
//        And verify the message is equal to “It's enabled!”
        WebElement text1 = waitForVisibility(By.xpath("//p[@id='message']"),10);
        Assert.assertTrue(text1.isDisplayed());

//        And verify the textbox is enabled (I can type in the box)
        WebElement textBox = driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertTrue(textBox.isEnabled());

//        And click on Disable button
        driver.findElement(By.xpath("//button[text()='Disable']")).click();
//        And verify the message is equal to “It's disabled!”
        WebElement text2 = waitForVisibility(By.xpath("//p[@id='message']"),10);
//        And verify the textbox is disabled (I cannot type in the box)
        Assert.assertFalse(textBox.isEnabled());
//        NOTE: .isEnabled(); is used to check if an element is enabled or not
    }
}
