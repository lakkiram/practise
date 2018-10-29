package orangehrm;

import java.sql.Driver;
import java.util.List;

import org.bridj.cpp.std.list;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Exforredbus {

	public static void main(String[] args) throws Exception{
		//for notifiction
				ChromeOptions options=new ChromeOptions();
				options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ammuk\\OneDrive\\Desktop\\selenium jars\\chromedriver.exe");
		WebDriver browser=new ChromeDriver(options);
		//maximize window
		browser.manage().window().maximize();
		//apply wait
		WebDriverWait wait=new WebDriverWait(browser,20);
		//to open application
		browser.navigate().to("https://www.redbus.in/");
		//creat webelement for from
		WebElement from=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("src")));
		from.sendKeys("Hyderabad");
		from.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		//creat webelement for to
		WebElement to=browser.findElement(By.id("dest"));
		to.sendKeys("Bangalore");
		to.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		//for date
		WebElement date=browser.findElement(By.xpath("//div[@id='rb-calendar_onward_cal']/table/tbody/tr[6]/td[5]"));
		date.click();
		//date.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		Actions act=new Actions(browser);
		act.moveToElement(browser.findElement(By.xpath("//label[contains(text(),'Return Date')]"))).click().perform();
		//return date
		WebElement returndate=browser.findElement(By.xpath("//div[@id='rb-calendar_return_cal']/table/tbody/tr[6]/td[6]"));
		returndate.click();
		//for search
		browser.findElement(By.id("search_btn")).click();
		//fornext page
		browser.get("https://www.redbus.in/search?fromCityName=Hyderabad&fromCityId=124&toCityName=Bangalore&toCityId=122&onward=26-Oct-2018&return=27-Oct-2018&opId=0&busType=Any");
	   Thread.sleep(2000);
		int row;
		List<WebElement> li= browser.findElements(By.xpath("//div[@class='travels lh-24 f-bold d-color']"));
	    for(row=0;row<98;row++) {
	    li.get(row).getText();
	    if(row==55)
	    li.get(row).click();
	    }
		
	}

}
