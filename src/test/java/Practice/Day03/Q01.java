package Practice.Day03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Q01 extends TestBase {

    @Test
    public void test() {

        /*
    Given
        Go to https://demo.guru99.com/test/drag_drop.html
    When
        Drag orange elements on proper boxes below them
    Then
        Verify they are dropped.
 */

        driver.get("https://demo.guru99.com/test/drag_drop.html");

        WebElement bank = driver.findElement(By.id("credit2"));
        WebElement target = driver.findElement(By.id("bank"));

        WebElement sales = driver.findElement(By.id("credit1"));
        WebElement target2 = driver.findElement(By.id("loan"));

        WebElement price = driver.findElement(By.id("fourth"));
        WebElement debitAmount = driver.findElement(By.id("amt7"));

        WebElement creditAmount = driver.findElement(By.id("amt8"));


        Actions actions = new Actions(driver);

        actions.
                dragAndDrop(bank,target).
                dragAndDrop(sales,target2).
                dragAndDrop(price,debitAmount).
                dragAndDrop(price,creditAmount).
                build().
                perform();


        WebElement perfect = driver.findElement(By.id("equal"));
        Assert.assertTrue(perfect.isDisplayed());










    }
}
