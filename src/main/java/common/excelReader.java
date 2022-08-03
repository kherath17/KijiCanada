package common;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class excelReader {
 public String readData(int row, int col) throws IOException {
     File file =    new File("C:\\Users\\E-LINE\\Desktop\\Fiverrr\\data.xlsx");
     FileInputStream inputStream = new FileInputStream(file);
     XSSFWorkbook wb=new XSSFWorkbook(inputStream);

     XSSFSheet sheet=wb.getSheet("PostAd");
     String data = sheet.getRow(row).getCell(col).toString();
     return data;
 }
}
