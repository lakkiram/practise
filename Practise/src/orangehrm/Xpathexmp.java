package orangehrm;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Xpathexmp {

	public static void main(String[] args)throws Exception {
System.setProperty("webDriver.chrome.driver","C:\\Users\\ammuk\\OneDrive\\Desktop\\selenium jars\\chromedriver.exe");
ChromeDriver driver=new ChromeDriver();
//Maximize browser
driver.manage().window().maximize();
driver.get("https://www.facebook.com/");
Thread.sleep(2000);
WebElement objUN=driver.findElement(By.xpath("html/body/div/div[2]/div/div/div/div/div[2]/form/input"));
WebElement objpwd=driver.findElement(By.xpath("//table[@role='presentation']/tbody/tr[2]/td[2]/input"));
String sUN="";
String spwd="";


	}

}
