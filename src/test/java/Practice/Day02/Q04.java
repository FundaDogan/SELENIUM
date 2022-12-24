package Practice.Day02;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Q04 extends TestBase {
    /*
   Given
        Go to https://www.gmibank.com/
   When
        Hover over "Premium" Deposit Package
   And
        Click on "Book Now"
   Then
        Verify url contains "services"
    */

    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.gmibank.com/");

        Actions actions = new Actions(driver);

        WebElement source = driver.findElement(By.xpath("(//div[@class='pricing-details'])[2]"));

        Thread.sleep(2000);

        actions.moveToElement(source).perform();

        driver.findElement(By.xpath("(//a[@class='btn btn-blue initiate-scripts'])[2]")).click();

        Assert.assertTrue(driver.getCurrentUrl().contains("services"));

    }
}
