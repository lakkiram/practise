package orangehrm;

import java.io.File;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class Creatxlwithjxl {

	public static void main(String[] args) throws Exception{
		WritableWorkbook web=Workbook.createWorkbook(new File("C:\\Users\\ammuk\\Desktop\\hrmorg.xls"));
		WritableSheet ws=web.createSheet("hrmrg",0);
		WritableSheet ws1=web.createSheet("RES",1);
		Label lab=new Label(0,0,"Username");
		Label l1=new Label(1,0,"Password");
		Label l3=new Label(0,1,"qaplanet1");
		Label l2=new Label(1,1,"admin");
		ws.addCell(lab);
		ws.addCell(l1);
		ws.addCell(l3);
		ws.addCell(l2);	
		web.write();
		web.close();
		
		
		

	}

}
