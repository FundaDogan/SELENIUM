package review;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class R01 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.youtube.com");

        String actualTitle = driver.getTitle();

        String expectedTitle = "youtube";

        if (actualTitle.equals(expectedTitle)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("actual title is "+ actualTitle);
        }

        String actualURL = driver.getCurrentUrl();

        if (actualURL.contains("youtube")){
            System.out.println("pass");
        }else {
            System.out.println("fail");
            System.out.println("actual URL is "+ actualURL);
        }

        driver.navigate().to("https://www.amazon.com/");

        driver.navigate().back();

        driver.navigate().refresh();

        driver.navigate().forward();

        String actualTitle1 = driver.getTitle();

        if (actualTitle1.contains("Amazon")){
            System.out.println("pass");
        }else {
            System.out.println("fail");
            System.out.println(actualTitle1);
        }

        String actualURL1 = driver.getCurrentUrl();
        String expectedURL1 = "https://www.amazon.com/";

        if (actualURL1.equals(expectedURL1)){
            System.out.println("pass");
        }else {
            System.out.println("fail");
            System.out.println("current url is "+ actualURL1);
        }


        driver.quit();

    }
}
