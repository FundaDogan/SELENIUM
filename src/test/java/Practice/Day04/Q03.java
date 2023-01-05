package Practice.Day04;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;

public class Q03 extends TestBase {
    @Test
    public void test() {
//        Given
//        Go to https://testpages.herokuapp.com/styled/events/javascript-events.html
        driver.get("https://testpages.herokuapp.com/styled/events/javascript-events.html");

//        When
//        Click all the buttons
        driver.findElement(By.id("onblur")).click();
        waitFor(2);
        driver.findElement(By.id("onclick")).click();//these 2  is for clicking on "onBlur" button
        waitFor(2);
        driver.findElement(By.id("onclick")).click(); // this is for clicking on "onClick" button
        waitFor(2);

        Actions actions = new Actions(driver);

        WebElement onContext = driver.findElement(By.id("oncontextmenu"));// oncontext element

        WebElement onDouble = driver.findElement(By.id("ondoubleclick"));

        WebElement onFocus = driver.findElement(By.id("onfocus"));

        WebElement onKeyDown = driver.findElement(By.id("onkeydown"));

        WebElement onKeyUp = driver.findElement(By.id("onkeyup"));

        WebElement onKeyPress = driver.findElement(By.id("onkeypress"));

        WebElement onMouseOver = driver.findElement(By.id("onmouseover"));

        WebElement onMouseLeave = driver.findElement(By.id("onmouseleave"));

        WebElement onMouseDown = driver.findElement(By.id("onmousedown"));

        waitFor(1);
        actions.contextClick(onContext).perform();
        waitFor(1);
        actions.doubleClick(onDouble).perform();
        waitFor(1);
        actions.click(onFocus).perform();
        waitFor(1);
        actions.click(onKeyDown).sendKeys(Keys.ENTER).perform();
        waitFor(1);
        actions.click(onKeyUp).sendKeys(Keys.ENTER).perform();
        waitFor(1);
        actions.click(onKeyPress).sendKeys(Keys.ENTER).perform();
        waitFor(1);
        actions.moveToElement(onMouseOver).perform();
        waitFor(1);
        actions.moveToElement(onMouseLeave).perform();
        waitFor(1);
        actions.click(onMouseDown).perform();//This one did not work because of previous leave action
        waitFor(1);
        actions.click(onMouseDown).perform();


        // Assert all buttons clicked
        int numberOfClickedButtons = driver.findElements(By.xpath("//p[.='Event Triggered']")).size();
        assertEquals(11,numberOfClickedButtons);


    }
}
