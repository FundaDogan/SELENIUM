package review;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class JSExecuter extends TestBase {

    @Test
    public void test() {
        driver.get("https://techproeducation.com/");

        WebElement searchBox = driver.findElement(By.xpath("//input[@type='search']"));

        setValueByJS(driver.findElement(By.xpath("//input[@type='search']")), "Java");

    }

    @Test
    public void test1() {
        driver.get("https://www.priceline.com/");

        setValueByJS(driver.findElement(By.id("hotel-date-range-box")),"23/02/2023 – 11/03/2023" );

        setValueByJS(driver.findElement(By.xpath("//input[@name='endLocation']")),"London" );

        waitFor(3);

        driver.findElement(By.xpath("//input[@id='hotelDates']")).click();

        driver.findElement(By.xpath("(//div[@class='day-cell'])[20]")).click();

        driver.findElement(By.xpath("(//div[@class='day-cell'])[27]")).click();

    }
}
