package orangehrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Usageif {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
System.setProperty("webdriver.chrome.driver","C:\\Users\\ammuk\\OneDrive\\Desktop\\selenium jars\\chromedriver.exe");
ChromeDriver driver=new ChromeDriver();
//Maximize browser
driver.manage().window().maximize();
// -----------------------------------------------
//Open application
driver.get("http://apps.qaplanet.in/qahrm/login.php");
//wait 2 sec
Thread.sleep(2000);
//verify home page
if(driver.getTitle().equals("OrangeHRM - New Level of HR Management"))
{
	System.out.println("home page Displayed");
}
else
{

	System.out.println("failed to open home page");
return;
	
}
//create webelement for username

WebElement objUN=driver.findElement(By.name("txtUserName"));
WebElement objpwd=driver.findElement(By.name("txtPassword"));
WebElement objlog=driver.findElement(By.name("Submit"));
WebElement objclr=driver.findElement(By.name("clear"));
// verify user name and password
if(objUN.isDisplayed() && objpwd.isDisplayed());
{
	System.out.println("user name and password displayed");
}

if(objlog.isDisplayed()&& objclr.isDisplayed());
{
System.out.println("login and clear is displayed");

	}
//     ----------------
String sUN="qaplanet1";
String spwd="lab1";
// ---------------------------------------------------
//log into orangehrm
objUN.clear();
objUN.sendKeys(sUN);
objpwd.clear();
objpwd.sendKeys(spwd);
objlog.click();

//wait 2 sec
Thread.sleep(2000);
//verify orangehrm page
if(driver.getTitle().equals("OrangeHRM"))
{
	System.out.println("orangehrm page displayed");
	
}
else
	System.out.println("failed to login");



}
	
}
