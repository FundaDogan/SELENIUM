package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Day08_Actions2 extends TestBase {

//    Create test method : hoverOver() and test the following scenario:

    @Test
    public void hoverOverTest() throws InterruptedException {

        //    Given user is on the https://www.amazon.com/
        driver.get("https://www.amazon.ca/");

//    When use click on “Account” link
        Actions actions = new Actions(driver);

        WebElement accountList = driver.findElement(By.id("nav-link-accountList"));

        actions.moveToElement(accountList).perform();

        driver.findElement(By.linkText("Account")).click(); // fail buna bak

//    Then verify the page title contains “Your Account”
        Assert.assertTrue(driver.getTitle().contains("Your Account"));






    }

}
