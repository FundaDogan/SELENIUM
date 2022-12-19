package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Google extends TestBase {
//    Then create 3 different test methods using the following names. And Go to google.
//    titleTest =>Verify if google title = “Google”

    @Test
    public void titleTest(){
        driver.get("https://www.google.com");

        Assert.assertEquals("Google",driver.getTitle());

        driver.quit();

    }

//    imageTest => Verify if google image displays or not
    @Test
    public void imageTest(){

        driver.get("https://www.google.com");

        WebElement image = driver.findElement(By.id("hplogo"));
        Assert.assertTrue(image.isDisplayed());

        driver.quit();

    }


//    gmailLinkTest => Verify if the Gmail link is displayed or not
    @Test
    public void gmailLinkTest(){
        driver.get("https://www.google.com");
        WebElement gmail = driver.findElement(By.linkText("Gmail"));
        Assert.assertTrue(gmail.isDisplayed());

        driver.quit();
    }

//    Close the browser after each test
}
