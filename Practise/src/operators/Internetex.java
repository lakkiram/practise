package operators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Internetex {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
System.setProperty("webdriver.ie.driver","C:\\Users\\ammuk\\OneDrive\\Desktop\\selenium jars\\IEDriverServer.exe");
InternetExplorerDriver driver=new InternetExplorerDriver();
driver.get("http://apps.qaplanet.in/qahrm/login.php");
WebElement un=driver.findElement(By.name("txtUserName"));
WebElement pw=driver.findElement(By.name("txtPassword"));
WebElement cl=driver.findElement(By.name("Submit"));
WebElement ca=driver.findElement(By.name("clear"));
WebElement lg=driver.findElement(By.linkText("Logout"));
if(un.isDisplayed()&& un.isEnabled()) {
	un.sendKeys("qaplanet1");
}
if(pw.isDisplayed()&& pw.isEnabled()) {
	pw.sendKeys("lab1");
	

}
	Thread.sleep(1000);
if(cl.isDisplayed()&& cl.isEnabled()) {
	cl.click();
/*}
if(ca.isDisplayed()&& ca.isEnabled()) {
	ca.click();
	
}*/
}
if(lg.isDisplayed()&& lg.isEnabled()) {
	lg.click();
	

}
	
	driver.findElement(By.linkText("Logout")).click();;
	
}

	}	


