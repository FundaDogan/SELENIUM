package practices;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Q01 {

    // ...Practice 1...
    public static void main(String[] args) throws InterruptedException {

        // Set Driver Path
        System.setProperty("webdriver.chrome.driver","./src/resources/drivers/chromedriver.exe");

        // Create chrome driver object
        WebDriver driver = new ChromeDriver();

        // Maximize the window
        driver.manage().window().maximize();

        // Open google home page https://www.google.com/
        driver.get("https://www.google.com/");

        // Navigate to techproeducation home page https://techproeducation.com/
        driver.navigate().to("https://techproeducation.com/");

        Thread.sleep(1000);

        // Navigate back to google
        driver.navigate().back();

        Thread.sleep(1000);

        // Navigate forward to techproeducation
        driver.navigate().forward();

        Thread.sleep(1000);

        // Refresh the page
        driver.navigate().refresh();

        // Close/Quit the browser
        driver.quit();

        // And last step : print "ALL OK" on console
        System.out.println("ALL OK");
    }


}
