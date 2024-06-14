package com.amazon.qa.Utill;

import com.amazon.qa.Base.TestBase;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils extends TestBase {

   public static String getScreenshot(WebDriver driver,String methodName) throws IOException {
       String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
       String dest = System.getProperty("user.dir")+"/test-output/"+ methodName+dateName+".png";
       File finalDest = new File(dest);
       FileUtils.copyFile(src,finalDest);
       String screenshotName = methodName+dateName+".png";
       return screenshotName;
    }

    @DataProvider(name = "getdata")
    public  String[][] getDatafromExcel() throws IOException {
        File file = new File("C:\\Users\\gowth\\IdeaProjects\\AmazonTest\\src\\main\\java\\com\\amazon\\qa\\testdata\\logindata.xlsx");
        FileInputStream fileInputStream = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);
        int noOfRow = sheet.getLastRowNum();
        System.out.println("row: "+noOfRow);
        int noOfCol = sheet.getRow(0).getLastCellNum();
        System.out.println("column:"+noOfCol);
        System.out.println(noOfRow+"   "+ noOfCol);
        String[][] data = new String[noOfRow][noOfCol];
        for (int i=0; i<noOfRow;i++){
            XSSFRow row = sheet.getRow(i+1);
            for(int j=0;j<noOfCol;j++){
                DataFormatter df  = new DataFormatter();
                    XSSFCell cell  =row.getCell(j);
                data[i][j] =df.formatCellValue(cell);
            }
        }
        return data;
    }




    public static byte[]saveFailureScreenShot(WebDriver driver) {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }


}
