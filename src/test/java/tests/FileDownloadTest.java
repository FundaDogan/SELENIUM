package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDownloadTest extends TestBase {
//    downloadTest()

    @Test
    public void downloadTest() throws InterruptedException {

//    https://testcenter.techproeducation.com/index.php?page=file-download
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");


//    Download b10 all test cases
        driver.findElement(By.linkText("b10 all test cases")).click(); //downloading the file

        Thread.sleep(2000);//after click, it takes a few millisecond, so use hard wait

//    Then verify if the file downloaded successfully
        String homeDirectory = System.getProperty("user.home");
        String filePath = homeDirectory + "/Downloads/b10 all test cases, code.docx";

        Boolean isDownloaded = Files.exists(Paths.get(filePath));
        Assert.assertTrue(isDownloaded);

    }

}
