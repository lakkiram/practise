package orangehrm;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.expectThrows;

import java.security.PublicKey;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class Framework {

		WebDriver Brow;
		WebDriverWait wait;
		WebElement un;
		WebElement pwd;
		WebElement save;
		WebElement pim;
		WebElement code;
 Actions Act;
		public void configDriver(String Browser) 
		{ Act=new Actions(Brow);
			if(Browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\ammuk\\OneDrive\\Desktop\\selenium jars\\chromedriver.exe");
			Brow=new ChromeDriver();
		}
			else if(Brow.equals("IE"))
			{
				System.setProperty("WebDriver.IE driver","C:\\Users\\ammuk\\OneDrive\\Desktop\\selenium jars\\IEDriverServer.exe");
			
			Brow=new InternetExplorerDriver();
		}
			else if(Browser.equals("firefox"))
			{
				System.setProperty("webdriver.gecko.driver", "C:\\Users\\ammuk\\OneDrive\\Desktop\\selenium jars\\geckodriver.exe");
				Brow=new FirefoxDriver();
			}
			else
			{
				System.out.println("Invalied Driver");
			}
			wait=new WebDriverWait(Brow, 30);
			Brow.manage().window().maximize();
			}
		//close Browser
		public void closeBrowser()
		{
			Brow.close();
		}
		//quit object
		public void Quitobject()
		{
		Brow.quit();	
		}
	//open application
		public void openAAPS(String URL)
		{
			Brow.get(URL);
			wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management"));
			//verify home page
			assertEquals(Brow.getTitle(),"OrangeHRM - New Level of HR Management");
			Reporter.log("home page displayed");
			//creat objectfor un pwd
			un=Brow.findElement(By.name("txtUserName"));
			pwd=Brow.findElement(By.name("txtPassword"));
			//verify un & pwd
			assertTrue(un.isDisplayed()&& pwd.isDisplayed());
			Reporter.log("un,pwd are exists");
		}
			//log in to application
			public void loginTOOrangeHRM(String username,String password) {
				un.sendKeys("qaplanet1");
				pwd.sendKeys("lab1");
			//click on login
				Brow.findElement(By.name("Submit")).click();
				wait.until(ExpectedConditions.titleIs("OrangeHRM"));
				//verify home page
				assertEquals(Brow.getTitle(), "OrangeHRM");
				Reporter.log("orange hrm page displayed");
				//get welcome text
				String Welcometext=Brow.findElement(By.xpath("//html/body/div[@id='option-menu-bar']/ul/li[1]")).getText();
				//verify welcome text
				assertEquals(Welcometext, "Welcome "+username);
				Reporter.log("Welcome"+username+"displayed");
			// click on logout
				Brow.findElement(By.linkText("Logout"));
				wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management"));
				Reporter.log("sign of successfully and home page displayed");
			
		}
//add employe
			public void pim() {
				Brow.findElement(By.linkText("PIM"));
				Act.moveToElement(pim).perform();
				WebElement addemploye=Brow.findElement(By.linkText("Add Employee"));
				addemploye.click();
				Brow.switchTo().frame("rightMenu");
				WebElement pimaddemploye=Brow.findElement(By.xpath("//div[@class='mainHeading']/h2"));
				if(pimaddemploye.getText().equals("PIM : Add Employee"))
				{
					Reporter.log("add employe");
				}
				String code=Brow.findElement(By.name("txtEmployeeId")).getAttribute("value");
				 save=Brow.findElement(By.className("savebutton"));
				save.click();
				Alert A=Brow.switchTo().alert();
				if(A.getText().equals("Last Name Empty!")) {
					Reporter.log("Last Name Empty!");
					A.accept();
			}
				WebElement lastname=Brow.findElement(By.name("txtEmpLastName"));
				
				lastname.sendKeys("lakshmi");
				save.click();	
				Alert B=Brow.switchTo().alert();
				if(B.getText().equals("First Name Empty!"))
				{
					Reporter.log("First Name Empty!");
					B.accept();
				}
			}
				//send keys for add employe
				public void sendkeysforaddemp() {
					WebElement firstname=Brow.findElement(By.name("txtEmpFirstName"));
					firstname.sendKeys("k");
					
					save.click();
					//wait for Personal Details
					if(wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@class='mainHeading']/h2"),"Personal Details")))
					{
						Reporter.log("Personal details and text displayed");
					}
					else
					{
						System.out.println("Personal Details did not displayed");
					}
					//switch to parentframe
					Brow.switchTo().parentFrame();
					// -------------------------------------------
					//mouseover on pim
					Act.moveToElement(pim).perform();
					Brow.findElement(By.linkText("Employee List")).click();
					//switch to frame
					Brow.switchTo().frame("rightMenu");
					//verify employe information
					if(Brow.findElement(By.xpath("//div[@class='mainHeading']/h2")).getText().equals("Employee Information"))
					{
						Reporter.log("employe information displayed");
					}
					else
					{
						System.out.println("Failed to display Employee Information text");
					}
					//get row count
					int rc=Brow.findElements(By.xpath("//table/tbody/tr")).size();
					for(int i=1;i<=rc;i++)
					{
						String allcode=Brow.findElement(By.xpath("//table/tbody/tr["+i+"]/td[2]")).getText();
						WebElement allname=Brow.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]/a"));
						if(allcode.equals(code)&& allname.getText().equals("k lakshmi"))
						{
							System.out.println("successfully added");
							System.out.println(allcode+", "+allname.getText()+" displayed at: "+i);
							allname.click();
							break;
					
	}
}  

				}}  
















