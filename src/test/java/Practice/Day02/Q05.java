package Practice.Day02;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Q05 extends TestBase {

    @Test
    public void test() throws InterruptedException {
        //go to  https://demo.automationtesting.in/Static.html
        //drag and drop elements

        driver.get("https://demo.automationtesting.in/Static.html");

        Actions actions = new Actions(driver);

        WebElement source = driver.findElement(By.id("angular"));

        WebElement target = driver.findElement(By.id("droparea"));

        Thread.sleep(4000);
        actions.dragAndDrop(source,target).perform();



    }
}
