package Practice.Day05;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Q03 extends TestBase {

    @Test
    public void test() {
//        Given
//        Go to https://www.facebook.com/
        driver.get("https://www.facebook.com/");

//        When
//        Click on "Create New Account"
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();

//        And
//        Fill all the boxes by using keyboard actions class

        Actions actions = new Actions(driver);

        Faker faker = new Faker();

        driver.findElement(By.name("firstname")).sendKeys("John");
        actions.sendKeys(Keys.TAB).
                sendKeys("Doe").sendKeys(Keys.TAB).
                sendKeys(faker.internet().emailAddress()).sendKeys(Keys.TAB).
                sendKeys(faker.internet().password()).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys("Sep").sendKeys(Keys.TAB).
                sendKeys("12").sendKeys(Keys.TAB).
                sendKeys("2000").sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.ARROW_DOWN).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.ENTER).
                perform();

    }
}
