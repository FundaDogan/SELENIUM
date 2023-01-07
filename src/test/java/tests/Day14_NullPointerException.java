package tests;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import utilities.TestBase;

public class Day14_NullPointerException  {

    //    DECLARED BUT NEVER INSTANTIATED

    WebDriver driver;
    Faker faker;
    @Test
    public void nullPointerTest(){

        driver.get("https://techproeducation.com/");//NullPointerException since I did not instantiate driver
    }
    @Test
    public void nullPointerTest1(){

        System.out.println(faker.name().fullName());//NullPointerException  since I did not instantiate faker
    }


     int x;
     String str;

    @Test
    public void name() {
        System.out.println(x);
        System.out.println(str);
    }
    // son test pass because int ve string has default value 0 and null,already initialized.

}
