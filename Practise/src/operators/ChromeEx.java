package operators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.setProperty("webdriver.chrome.driver", "C:\\Users\\ammuk\\OneDrive\\Desktop\\selenium jars\\chromedriver.exe");
WebDriver driver=new ChromeDriver();
driver.get("http://apps.qaplanet.in/qahrm/login.php");
WebElement un=driver.findElement(By.name("txtUserName"));
WebElement ps=driver.findElement(By.name("txtPassword"));
WebElement cl=driver.findElement(By.name("Submit"));
WebElement ca=driver.findElement(By.name("clear"));


if(un.isDisplayed()&& un.isEnabled())
{
	un.sendKeys("qaplanet1");
}
if(ps.isDisplayed()&& ps.isEnabled())
{
	ps.sendKeys("lab1");
}

/*if(cl.isDisplayed()&& cl.isEnabled())
{
	cl.click();
}*/
if(ca.isDisplayed()&& ca.isEnabled())
{
	ca.click();
	
}
	}

}
