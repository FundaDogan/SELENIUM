package homework;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Syncronization3 extends TestBase {
    @Test
    public void syncronization1() {
 //       Go to https://the-internet.herokuapp.com/dynamic_controls
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
//        Click on remove button
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();
//        And verify the message is equal to “It's gone!”
        WebElement text1 = waitForVisibility(By.xpath("//p[text()=\"It's gone!\"]"),10);

//        Then click on Add button
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

//        And verify the message is equal to “It's back!”
        WebElement text2 = waitForVisibility(By.xpath("//p[@id='message']"),10);
    }
}
