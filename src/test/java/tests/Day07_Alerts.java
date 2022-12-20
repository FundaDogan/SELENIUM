package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Day07_Alerts extends TestBase {

    //        acceptAlert() => click on the first alert,
    @Test
    public void acceptAlert() throws InterruptedException {

        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();

        Thread.sleep(2000);

//         verify the text “I am a JS Alert” ,
        String actualAlertText = driver.switchTo().alert().getText();
        Assert.assertEquals("I am a JS Alert", actualAlertText);

        Thread.sleep(2000);

//        click OK ,
        driver.switchTo().alert().accept();

        Thread.sleep(2000);

//        and Verify “You successfully clicked an alert”
        String actualResult = driver.findElement(By.id("result")).getText();
        Assert.assertEquals("You successfully clicked an alert", actualResult);

        Thread.sleep(2000);

    }


    @Test
    public void dismissAlert() throws InterruptedException {

        //    dismissAlert()=> click on the second alert,

        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();

        Thread.sleep(2000);


//    verify text "I am a JS Confirm”,

        String actualAlertText = driver.switchTo().alert().getText();
        Assert.assertEquals("I am a JS Confirm", actualAlertText);

        Thread.sleep(2000);

//    click cancel,

        driver.switchTo().alert().dismiss();

        Thread.sleep(2000);

//    and Verify “You clicked: Cancel”

        String actualResult = driver.findElement(By.id("result")).getText();
        Assert.assertEquals("You clicked: Cancel", actualResult);

        Thread.sleep(2000);
    }



    @Test
    public void sendKeysAlert() throws InterruptedException {

        //    sendKeysAlert()=> click on the third alert,

        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();

        Thread.sleep(2000);

//    verify text “I am a JS prompt”,

        String actualAlertText = driver.switchTo().alert().getText();
        Assert.assertEquals("I am a JS prompt",actualAlertText);

        Thread.sleep(2000);

//    type “Hello World”,
        driver.switchTo().alert().sendKeys("Hello World");

        Thread.sleep(2000);

//    click OK,
        driver.switchTo().alert().accept();

        Thread.sleep(2000);

//    and Verify “You entered: Hello World”

        String actualResult = driver.findElement(By.id("result")).getText();
        Assert.assertEquals("You entered: Hello World",actualResult);

        Thread.sleep(2000);

    }
}