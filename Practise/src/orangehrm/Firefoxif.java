package orangehrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefoxif {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver","C:\\Users\\ammuk\\OneDrive\\Desktop\\selenium jars\\geckodriver.exe");
		FirefoxDriver driver= new FirefoxDriver();
		driver.manage().window().maximize();
		// ---------------- ---------------
		//open application
		driver.get("http://apps.qaplanet.in/qahrm/login.php");
		//wait 2sec
		Thread.sleep(2000);
		if(driver.getTitle().equals("OrangeHRM - New Level of HR Management"))
		{
			System.out.println("displayed home page");
		}
		else
		{
			
		System.out.println("faild to display home page");
		
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

		if(objlog.isDisplayed()&& objclr.isDisplayed());
		{
			System.out.println("login and clear displayed");
		}
		// -------------------------------
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
		if(driver.getTitle().equals("OrangeHRM "))
		{
			System.out.println("orangehrm page displayed");
			
		}
		
		else
			System.out.println("failed to login");
		
		
}
	}	
