package Practice.Day06;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q01 {
    @Test
    public void test() throws IOException {
        //Note : because we are not doing UI test we don't need to extend the class to testbase

//        Given
//        Save EarningList.xlsx file into your project
//                When
//        In the row column, write the row numbers according to the earnings amount. (elemanlari liste sirasini
        //degistirmeden kopyalayacagim, sonra sort and reverse.

        String path = "./src/test/java/resources/EarningList.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);

        Workbook workbook = WorkbookFactory.create(fileInputStream);

        Sheet sheet1 = workbook.getSheet("Sheet1");

        List<Double> earnings = new ArrayList();

        for (int i=1; i<=sheet1.getLastRowNum(); i++){
            earnings.add(Double.valueOf(sheet1.getRow(i).getCell(1).toString()));
        }
        System.out.println("earnings :" + earnings);

        List<Double> sortedEarnings = new ArrayList<>(earnings);
        Collections.sort(sortedEarnings);
        Collections.reverse(sortedEarnings);

        System.out.println("sortedEarnings = "+ sortedEarnings);

        //        Then
//        Assert that row number of Wednesday is 1

        for (int i=0; i<earnings.size(); i++){
            for (int j=0; j< earnings.size(); j++){

                if (sortedEarnings.get(i)==earnings.get(j)){

                    sheet1.getRow(j+1).createCell(2).setCellValue(i+1);
                }
            }
        }

        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);

        //Assert that row number of Wednesday is 1
        Cell cell = sheet1.getRow(3).getCell(2);
        Assert.assertEquals("1.0",cell.toString());

    }
}
