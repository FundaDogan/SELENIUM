package homework;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class GoogleSearchTest extends TestBase {
//    Create a new class : GoogleSearchTest

//    Create Test method and complete the following task.

    @Test
    public void test(){
        driver.get("https://www.google.com/");
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("porcelain teapot");

        driver.findElement(By.xpath("//input[@class='gNO89b']")).click();

        WebElement results = driver.findElement(By.id("result-stats"));
        System.out.println(results.getText());
    }

//    When user goes to https://www.google.com/
//    Search for “porcelain teapot”
//    And print how many related results displayed on Google
}
