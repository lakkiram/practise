package orangehrm;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Jobsepcification {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ammuk\\OneDrive\\Desktop\\selenium jars\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//maximize window
		driver.manage().window().maximize();
		driver.get("http://apps.qaplanet.in/qahrm/login.php");
		//homepage verify
		WebDriverWait wait=new WebDriverWait(driver,60);
		if(wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management")))
				{
			System.out.println("display orange hrm");
				}
			else
			{ 
				System.out.println("not displayed");
			}
		//create webelements
		WebElement username=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtUserName")));
		WebElement password=driver.findElement(By.name("txtPassword"));
		WebElement login=driver.findElement(By.name("Submit"));
		WebElement clear=driver.findElement(By.name("Submit"));
		if(username.isDisplayed())

		{
		System.out.println("display username");
				}
		if(password.isDisplayed())

		{
		System.out.println("display password");
				}
		if(login.isDisplayed())

		{
		System.out.println("display login");
				}
		if(clear.isDisplayed())

		{
		System.out.println("display clear");
				}
		String un="qaplanet1";
		String pwd="lab1";
		//sendkeys
		username.clear();
		username.sendKeys(un);
		password.clear();
		password.sendKeys(pwd);
		login.click();
		if(wait.until(ExpectedConditions.titleIs("OrangeHRM")))
		{

		System.out.println("display homepage");

		}
		else {
			System.out.println("faield to login");
			
		}

		String sWelText=driver.findElement(By.cssSelector("#option-menu>li:nth-child(1)")).getText();
		if(sWelText.equals("welcome" + un))
		{
			System.out.println("welcome qaplanet displayed");
		}
		else
		{
			System.out.println("not displayed");
			
		}
		String[] Arr=sWelText.split(" ");
		if(Arr[1].equals(un))
		{
			System.out.println(un+" displayed");
		}
		WebElement admin=driver.findElement(By.linkText("Admin"));
		Actions Act=new Actions(driver);
		Act.moveToElement(admin).perform();
		Thread.sleep(2000);
		List<WebElement> li=driver.findElements(By.xpath("//li[@id='admin']/ul/li/a/span"));
		Iterator<WebElement> ad=li.iterator();
		while(ad.hasNext()) {
			WebElement c=ad.next();
			
			if(c.isDisplayed())
			{
				System.out.println(c.getText());
			}
			Act.moveToElement(c).perform();
			List<WebElement> sub=driver.findElements(By.xpath("//li[@id='admin']/ul/li/ul/li/a/span"));
			for(WebElement loc:sub)
			{
				if(loc.isDisplayed()) {
					System.out.println("   -"+loc.getText());
				}	}}
//select job specification
				WebElement job=driver.findElement(By.linkText("Job"));
				Act.moveToElement(job).perform();
				WebElement jobspecification=driver.findElement(By.linkText("Job Specifications"));
				jobspecification.click();
		//verify jobspecification title page
				driver.switchTo().frame("rightMenu");
				WebElement jobspe=driver.findElement(By.xpath("//div[@class='mainHeading']"));
				if(jobspe.getText().equals("Job : Job Specifications"))
				{
					System.out.println("print jobspepage");
				}
				WebElement searchby=driver.findElement(By.name("loc_code"));
				WebElement searchfor=driver.findElement(By.name("loc_name"));
				WebElement search=driver.findElement(By.xpath("//input[@value='Search']"));
				WebElement reset=driver.findElement(By.xpath("//input[@value='Reset']"));
				WebElement add=driver.findElement(By.xpath("//input[@value='Add']"));
				WebElement delete=driver.findElement(By.xpath("//input[@value='Delete']"));
				if(searchby.isDisplayed()&&(searchfor.isDisplayed()&&(search.isDisplayed()&&(reset.isDisplayed()&&(add.isDisplayed()&&(delete.isDisplayed()))))))
				{
					System.out.println("displayed all feilds");
				}
				add.click();
				if(driver.findElement(By.xpath("//div[@class='mainHeading']/h2")).getText().equals("Job : Job Specifications")); 
				System.out.println(" display Job Specifications page");
				//with out enter data click on save
				WebElement save=driver.findElement(By.xpath("//input[@value='Save']"));
				save.click();
				//handle alert
				Alert a=driver.switchTo().alert();
				System.out.println(a.getText());
				if(a.getText().equals("Please correct the following\n\n\t- Please specify Job Specification name\n"));
				System.out.println("sucess");
				a.accept();
				WebElement name=driver.findElement(By.name("txtFieldName"));
				name.sendKeys("lakki");
				save.click();
				//verify successfully
				if(wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//span[@class='success']"), "Successfully Added")));
				System.out.println("Successfully Added");
				//edit job specification
				WebElement searchby1=driver.findElement(By.name("loc_code"));
				WebElement searchfor1=driver.findElement(By.name("loc_name"));
				WebElement search1=driver.findElement(By.xpath("//input[@value='Search']"));
				Select s=new Select(searchby1);
				s.selectByVisibleText("Name");
				searchfor1.sendKeys("lakki");
				search1.click();
			WebElement name2=driver.findElement(By.xpath("//tbody/tr/td[3]/a"));
			if(name2.getText().equals("lakki"))
			System.out.println("print name");
			name2.click();
			WebElement edit=driver.findElement(By.xpath("//input[@value='Edit']"));
			edit.click();
			WebElement name3=driver.findElement(By.id("txtFieldName"));
			name3.clear();
			name3.sendKeys("chinnu");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@value='Save']")).click();
			//verify Successfully updatedpage
			if(wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//span[@class='success']"), "Successfully Updated")));
				System.out.println("Successfully Updated");
				//delete jod specification
				WebElement delete1=driver.findElement(By.xpath("//input[@value='Delete']"));
				delete1.click();
				//handle alert with out selecting any item
				Alert b=driver.switchTo().alert();
				System.out.println(b.getText());
				if(b.getText().equals("Select at least one record to delete"))
					b.accept();
				//driver.findElement(By.xpath("//tbale/descendant::td/a/[contains(text(),'chinnu')]/ancestor::td/preceding-sibiling::td/input")).click();
				delete1.click();
				//handle alert
				Alert c=driver.switchTo().alert();
				if(c.getText().equals("Deletion might affect employee information. Do you want to delete ?"));
				c.accept();
				//verify Successfully deletedpage
				if(wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//span[@class='success']"), "Successfully Deleted")));
					System.out.println("Successfully Deleted");
				
			
		
				
				

				
				
				
				
				
				
				
				
				
				
				
				
				
	}

}
