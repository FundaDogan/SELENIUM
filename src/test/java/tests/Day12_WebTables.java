package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Day12_WebTables extends TestBase {

    @Test
    public void printTableData() {

        driver.get("https://the-internet.herokuapp.com/tables");

//        Task 1 : Print the entire table
        System.out.println("PRINT ENTIRE TABLE***");
        String entireTable = driver.findElement(By.xpath("//table[@id='table1']")).getText();
        System.out.println(entireTable);

        List<WebElement> allTableElements = driver.findElements(By.xpath("//table[@id='table1']//td"));
        for (WebElement eachElement : allTableElements){
            System.out.println(eachElement.getText());
        }

//        We can get specific cell data
        System.out.println("5th DATA in the table "+allTableElements.get(5).getText());

    }

    @Test
    public void printRows(){

        //        Task 2 : Print All Rows

        driver.get("https://the-internet.herokuapp.com/tables");

        List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='table1']//tr"));
        int rowNum=1;
        for (WebElement eachRow:allRows){
            System.out.println("Row "+rowNum+" => "+eachRow.getText());
            rowNum++;
        }

//        We can get specific row data
        System.out.println("5th Row Data : "+allRows.get(4).getText());

//        Task 3 : Print Last row data only
        System.out.println("Last Row Data : "+allRows.get(allRows.size()-1).getText());

    }
}
