package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Syncronization2 extends TestBase {
    @Test
    public void synchronization2() {

//        Go to https://the-internet.herokuapp.com/dynamic_loading/2
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");

//        When user clicks on the Start button
        driver.findElement(By.xpath("//button[text()='Start']")).click();

//        Then verify the ‘Hello World!’ Shows up on the screen

        WebElement helloWorld = waitForVisibility(By.xpath("//h4[text()='Hello World!']"),15);
        Assert.assertTrue(helloWorld.isDisplayed());
    }
}
