package common;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class excelReader {
    public  int row;
    public excelReader()  {
        try{
            File file =    new File("C:\\Users\\siva2\\Desktop\\TestAutomation\\KijiCanada\\src\\main\\java\\dataFile\\data.xls");
            FileInputStream inputStream = new FileInputStream(file);
            HSSFWorkbook wb=new HSSFWorkbook(inputStream);

            HSSFSheet sheet=wb.getSheet("PostAd");
            row =sheet.getLastRowNum();
        }catch (Exception e){
            e.getCause();
        }

    }
 public String readData(int row, int col) throws IOException {
     File file =    new File("C:\\Users\\siva2\\Desktop\\TestAutomation\\KijiCanada\\src\\main\\java\\dataFile\\data.xls");
     FileInputStream inputStream = new FileInputStream(file);
     HSSFWorkbook wb=new HSSFWorkbook(inputStream);

     HSSFSheet sheet=wb.getSheet("PostAd");
     //row =sheet.getLastRowNum();
     String data = sheet.getRow(row).getCell(col).toString();
     return data;
 }
}
