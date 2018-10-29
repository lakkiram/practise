package orangehrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cssexp {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ammuk\\OneDrive\\Desktop\\selenium jars\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://apps.qaplanet.in/qahrm/login.php");
		WebElement username=driver.findElement(By.cssSelector("input[name='txtUserName']"));
	WebElement password=driver.findElement(By.cssSelector("html>body>form>table>tbody>tr>td:nth-child(2)>table>tbody>tr>td:nth-child(2)>table>tbody>tr:nth-child(3)>td:nth-child(2)>input"));
	WebElement login=driver.findElement(By.cssSelector("input.button[type='Submit']"));
	WebElement clear=driver.findElement(By.cssSelector("input[type='reset'"));
	
	}

}
