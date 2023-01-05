package Practice.Day04;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Q01 extends TestBase {

    @Test
    public void test() {

//  Given
//    Go to  https://www.saucedemo.com/
        driver.get("https://www.saucedemo.com/");
//  When

//    Enter the username  as "standard_user"
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
//  And
//    Enter the password as "secret_sauce"
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
//  And
//    Click on login button
        driver.findElement(By.id("login-button")).click();

//  And
//    Add al products to cart

        List<WebElement> list = driver.findElements(By.xpath("//button[.='Add to cart']"));
        for (WebElement w: list){
            w.click();
        }

//  And
//    Go to cart
        driver.findElement(By.id("shopping_cart_container")).click();


//  And
//    Click on checkout
        driver.findElement(By.id("checkout")).click();
//  And
//    Fill your information
        Faker faker = new Faker();
        driver.findElement(By.id("first-name")).sendKeys(faker.name().firstName());
        driver.findElement(By.id("last-name")).sendKeys(faker.name().lastName());
        driver.findElement(By.id("postal-code")).sendKeys(faker.address().zipCode());
//  And
//    Click on continue
        driver.findElement(By.id("continue")).click();
//  Then
//    Assert that total price is $140.34
        String totalPrice = driver.findElement(By.xpath("//div[@class='summary_total_label']")).getText();
        Assert.assertEquals("Total: $140.34",totalPrice);

//  When
//    Click on finish
        driver.findElement(By.id("finish")).click();
//  Then
//    Assert that CHECKOUT: COMPLETE!
        String text = driver.findElement(By.xpath("//span[.='Checkout: Complete!']")).getText();
        Assert.assertEquals("CHECKOUT: COMPLETE!",text);

    }
}
