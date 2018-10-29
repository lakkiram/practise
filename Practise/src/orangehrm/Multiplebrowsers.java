package orangehrm;


import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Multiplebrowsers {

	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ammuk\\OneDrive\\Desktop\\selenium jars\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//Maximize browser
				driver.manage().window().maximize();
				//wait object
				WebDriverWait wait=new WebDriverWait(driver,60);
	driver.get("http://qaplanet.in/");
	//click on linkedicon
	driver.findElement(By.xpath("//div[@id='section-tophat']/div/div/div[2]/ul/li[4]/a/img")).click();
	Set<String>IDS=driver.getWindowHandles();
	//way1
	for(String id:IDS)
	{
		System.out.println(id);
	}
//way2
	Iterator<String>ITR=IDS.iterator();
	String First_ID=ITR.next();
	String second_ID=ITR.next();
	//switch to second browser
	driver.switchTo().window(second_ID);
	driver.findElement(By.linkText("Sign in"));
	//close browser
	driver.close();
	//switch to parent browser
	driver.switchTo().window(First_ID);
	//execute code
	//click on justdail
	driver.findElement(By.xpath("//div[@id='section-tophat']/div/div[1]/div[2]/ul/li[5]/a/img")).click();
	//execute code
	driver.close();
	driver.quit();
	
	
	
	
	
	
	
	
	
	
	
	
	

	}

}
