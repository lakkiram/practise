package orangehrm;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Tooltipexp {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ammuk\\OneDrive\\Desktop\\selenium jars\\chromedriver.exe");
WebDriver brow= new ChromeDriver();
brow.get("https://www.google.com/");
brow.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
brow.findElement(By.id("lst-ib")).sendKeys("selenium");


	}

}
