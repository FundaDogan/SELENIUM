package Practice.Day02;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Q01 extends TestBase {

    /*
    Given
         Go to url : https://phptravels.com/demo/
    When
         Fill the form
    And
         Click on 'SUBMIT'
    Then
         Assert that the form has been sent
     */

    @Test
    public void test() throws InterruptedException {
        driver.get("https://phptravels.com/demo/");
        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("Eda");
        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("Bulut");
        driver.findElement(By.xpath("//input[@name='business_name']")).sendKeys("QA Tester");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("edaBulut@gmail.com");

        int num1 = Integer.parseInt(driver.findElement(By.id("numb1")).getText());
        int num2 = Integer.parseInt(driver.findElement(By.id("numb2")).getText());

        int result = num1+num2;

        driver.findElement(By.id("number")).sendKeys(String.valueOf(result));

        //driver.findElement(By.id("demo")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[@id='demo']")).click();

        Thread.sleep(2000);

        driver.switchTo().alert().accept();

        Thread.sleep(2000);

        WebElement text = driver.findElement(By.xpath("//p[@class='text-center cw']"));
        Assert.assertTrue(text.isDisplayed());

    }
}
