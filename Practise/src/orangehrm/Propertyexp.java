package orangehrm;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Propertyexp {

	public static void main(String[] args) throws Exception {
		Properties pro=new Properties();
		pro.load(new FileInputStream("C:\\Users\\ammuk\\testworkspace\\Practise\\src\\orangehrm\\Org.properties"));
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ammuk\\OneDrive\\Desktop\\selenium jars\\chromedriver.exe");		
			WebDriver driver=new ChromeDriver();
			String url=pro.getProperty("url");
			String title=pro.getProperty("title");
			String 	unloc=pro.getProperty("unloc");
			String pwdloc=pro.getProperty("pwdloc");
					driver.get(url);
			WebDriverWait wait=new WebDriverWait(driver,60);
			if(wait.until(ExpectedConditions.titleIs(title)))
			{
				System.out.println("Home Page Displayed");
			}
			else
			{
				System.out.println("Failed to open home page");
				return;
	}
			WebElement un=driver.findElement(By.name(unloc));
			WebElement pwd=driver.findElement(By.name(pwdloc));
			String username=pro.getProperty("username");
			un.sendKeys(username);
			String password=pro.getProperty("password");
			pwd.sendKeys(password);
String login=pro.getProperty("login");
driver.findElement(By.name("Submit")).click();



}
}