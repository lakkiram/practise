package orangehrm;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Internetexploreexm {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
System.setProperty("webdriver.edge.driver","C:\\Users\\ammuk\\OneDrive\\Desktop\\selenium jars\\MicrosoftWebDriver.exe");
EdgeDriver driver= new EdgeDriver();
// ----------------------------------------
// to maximizebroser
driver.manage().window().maximize();
//               -------------------------------
//open application
driver.get("http://apps.qaplanet.in/qahrm/login.php");
//wait 2sec
Thread.sleep(2000);
if(driver.getTitle().equals("OrangeHRM - New Level of HR Management"))
{
	System.out.println("display homepage");
}
	else
	{
		System.out.println("faild to displayhomepage");
	}
//creat webelement for user name
WebElement objun=driver.findElement(By.name("txtUserName"));
WebElement objpwd=driver.findElement(By.name("txtPassword"));
WebElement objlog=driver.findElement(By.name("Submit"));
WebElement objclr=driver.findElement(By.name("clear"));


// -----------------------------------------
if(objun.isDisplayed()&& objpwd.isDisplayed())
{
System.out.println("username and password displayed");	
}
if(objlog.isDisplayed()&& objclr.isDisplayed())
{
	System.out.println("longin and clear displayed");
}
//-------------------------------
		String sun="qaplanet1";
		String spwd="lab1";
		//  ----------------------------------------
		objun.clear();
		objun.sendKeys(sun);
		objpwd.clear();
		objpwd.sendKeys(spwd);
		objlog.click();
		//wait 2sec
		Thread.sleep(2000);
		//verify orangehrm page
		if(driver.getTitle().equals("OrangeHRM"))
		{
			System.out.println("orangehrm page displayed");
		}
		
		else
		{
			System.out.println("failed to login");
		}
		// -------------------------
		//click on logout
		WebElement objlogout=driver.findElement(By.linkText("Logout"));
		objlogout.click();
		//wait 2sec
		Thread.sleep(2000);
		//virify homepage
		if(driver.getTitle().equals("OrangeHRM - New Level of HR Management"))
		{
		System.out.println("sign off sucessfull andhomepage displayed");
		}
		else
		{
			System.out.println("failed to signoff");
			return;
		}
	// ---------------------------------------------
		driver.close();
		driver.quit();
}
	
	



	}


