package Practice.Day04;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.awt.*;

import static org.junit.Assert.assertEquals;

public class Q05 extends TestBase {
    @Test
    public void test() {
        //Go to https://testpages.herokuapp.com/styled/basic-html-form-test.html
        driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");

        //Fill the username, password and textArea comment:

        Faker faker = new Faker();

        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(faker.name().username());

        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(faker.internet().password());

        WebElement comment = driver.findElement(By.xpath("//textarea[@name='comments']"));
        comment.clear();
        comment.sendKeys("Hello, I am a comment");


        //Choose a file and upload it

        String userHome = System.getProperty("user.home");
        driver.findElement(By.name("filename")).sendKeys(userHome+"\\Desktop\\logo.jpeg");


        //Select checkbox1, radio item 3 and dropdown1
        WebElement checkbox1 = driver.findElement(By.xpath("//input[@value='cb1']"));//checkbox1

        if (!checkbox1.isSelected()){
            checkbox1.click();
        }

        driver.findElement(By.xpath("//input[@value='rd3']")).click(); //radio3

        WebElement dropdown = driver.findElement(By.xpath("//select[@name='multipleselect[]']"));

        Select select = new Select(dropdown);
        select.deselectAll();

        driver.findElement(By.xpath("//option[@value='ms1']")).click();

        //Click on submit
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        //Verify that uploaded file name is on the Form Details.
        WebElement text = driver.findElement(By.id("_valuefilename"));
        Assert.assertTrue(text.isDisplayed());



    }
}
