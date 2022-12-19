package homework;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class AmazonSearch extends TestBase {

//    Create a new class: AmazonSearch

//    //TC01_As user I want to know how many items are there on amazon in the first page after I search
//    “porcelain teapot”?

    @Test
    public void test1(){
        driver.get("https://amazon.ca");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("porcelain teapot");

        driver.findElement(By.id("nav-search-submit-button")).click();
        WebElement number = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(number.getText());
    }

//    //TC02_Order the the tea pot prices, find the min, max, and average price to the nearest cent.
    @Test
    public void test2(){
        driver.get("https://amazon.ca");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("porcelain teapot");
        driver.findElement(By.id("nav-search-submit-button")).click();

        WebElement dropdown = driver.findElement(By.xpath("//i[@class='a-icon a-icon-dropdown']"));

        Select select = new Select(dropdown);
        select.selectByIndex(1);


    }
}
