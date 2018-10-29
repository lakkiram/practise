package operators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefoxexm {

public static void main(String[] args)
{
	
System.setProperty("webdriver.gecko.driver","C:\\Users\\ammuk\\OneDrive\\Desktop\\selenium jars\\geckodriver.exe");
FirefoxDriver Driver=new FirefoxDriver();
Driver.get("http://apps.qaplanet.in/qahrm/login.php");
WebElement un=Driver.findElement(By.name("txtUserName"));
WebElement ps=Driver.findElement(By.name("txtPassword"));
WebElement cl=Driver.findElement(By.name("Submit"));
WebElement ca=Driver.findElement(By.name("clear"));
WebElement lg=Driver.findElement(By.linkText("Logout"));
if (un.isDisplayed()&& un.isEnabled());
{
	un.sendKeys("qaplanet1");

	}

if (ps.isDisplayed()&& ps.isEnabled());
{
	ps.sendKeys("lab1");

	}
if (cl.isDisplayed()&& cl.isEnabled());
{
	cl.click();
}
	if(lg.isDisplayed()&& lg.isEnabled()) {
		lg.click();
		

	}
		
		
	
	//}
//if (ca.isDisplayed()&& ca.isEnabled());
//{
	//ca.click();
//}
	
}
}

