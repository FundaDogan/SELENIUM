package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day01_BasicNavigations {
    public static void main(String[] args) {

        // 1. Step: set up
        System.setProperty("webdriver.chrome.driver","./src/resources/drivers/chromedriver.exe");

        // 2. Step: Create driver
        WebDriver driver = new ChromeDriver();

        //3.Step: Write test scripts
        //Maximize the window

        driver.manage().window().maximize();

//        Open google home page https://www.walmart.com/
        driver.get("https://www.walmart.com/");

//        On the same class, Navigate to amazon home page https://www.amazon.com/
        driver.navigate().to("https://www.amazon.com");

//        Navigate back to walmart
       driver.navigate().back();

//        Navigate forward to amazon
        driver.navigate().forward();

//        Refresh the page
        driver.navigate().refresh();

//        Close/Quit the browser
       driver.quit();

    }
}
