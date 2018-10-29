package orangehrm;



import java.io.File;

import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;

public class Workwithxl {
	
@Test
	public void ReadDataFromXLSE()throws Exception {
	//totake files as input use file
		File f1=new File("C:\\Users\\ammuk\\OneDrive\\Desktop\\Book.xls");
		//load a work book
		Workbook wb=Workbook.getWorkbook(f1);
		//get specific sheet
		Sheet s1=wb.getSheet("org");
		int i=1;
		String Brow=s1.getCell(0,i).getContents();
		String Url=s1.getCell(1,i).getContents();
		String Un=s1.getCell(2,i).getContents();
		String Pwd=s1.getCell(3,1).getContents();
		System.out.println(Brow);
		System.out.println(Url);
		System.out.println(Un);
		System.out.println(Pwd);
		
		

	}

}
