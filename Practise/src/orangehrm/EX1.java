package orangehrm;

import org.sikuli.script.App;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

public class EX1 {

	public static void main(String[] args) throws FindFailed {
		App.open("calc.exe");
		Screen x= new Screen();
		//verify calc window
		if(x.exists("C:\\Users\\ammuk\\OneDrive\\Desktop\\sikuli\\calc.png")!=null)
		{
			System.out.println("Cal window is displayed");
		}
		x.click("C:\\Users\\ammuk\\OneDrive\\Desktop\\sikuli\\Eight.png");
		x.click("C:\\Users\\ammuk\\OneDrive\\Desktop\\sikuli\\Threess.png");

	}

}
