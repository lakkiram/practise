package orangehrm;




import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Apachepoi {

	public static void main(String[] args) throws IOException {
	XSSFWorkbook wb=new XSSFWorkbook();
XSSFSheet sheet=wb.createSheet("sheet1");
int row=0;
int column=0;
Row r1=sheet.createRow(row);
r1.createCell(column).setCellValue("mobile");
column++;
r1.createCell(column).setCellValue("Price");
FileOutputStream fp=new FileOutputStream("C:\\Users\\flipcart.xlsx");
wb.write(fp);

	}

}
