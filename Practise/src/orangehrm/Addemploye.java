package orangehrm;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Addemploye {

	public static void main(String[] args) throws Exception  {
	
System.setProperty("webdriver.chrome.driver","C:\\Users\\ammuk\\OneDrive\\Desktop\\selenium jars\\chromedriver.exe");
WebDriver driver=new ChromeDriver();
//Maximize browser
		driver.manage().window().maximize();
		//wait object
		WebDriverWait wait=new WebDriverWait(driver,60);
		//action class object
		Actions Act=new Actions(driver);
		//------------------------------------------------
				//Open application
		driver.get("http://apps.qaplanet.in/qahrm/index.php");
		//Verify home page
				if(wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management")))
				{
					System.out.println("Home Page Displayed");
				}
				else
				{
					System.out.println("Failed to open home page");
					return;
				}
				// -------------------------------
				//Create webelements
				WebElement objUserName=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtUserName")));
				WebElement objPassword=driver.findElement(By.name("txtPassword"));
				WebElement objLogin=driver.findElement(By.name("Submit"));
				WebElement objClear=driver.findElement(By.name("clear"));
				//-------------------------------------------------------------
				//Verify user name
				if(objUserName.isDisplayed())
				{
					System.out.println("username displayed");
				}
		//verify password
				if(objPassword.isDisplayed())
				{
		System.out.println("password displayed");
		
	}
//verifylogin
				if(objLogin.isDisplayed())
				{
					
				System.out.println("login is displayead");
				}
				
					if(objClear.isDisplayed())
					{System.out.println("clear is displayed");
					//--------------------------------------------------------------
					String sUN="qaplanet1";
					String sPWD="lab1";
					//--------------------------------------------------------------
					//Login to orangeHRM
					objUserName.clear();
					objUserName.sendKeys(sUN);
					objPassword.clear();
					objPassword.sendKeys(sPWD);
					objLogin.click();
					//Verify OrangeHRM page
					if(wait.until(ExpectedConditions.titleIs("OrangeHRM")))
					{
						System.out.println("OrangeHRM Page Displayed");
						
					}
				
					else
					{System.out.println("failed to login");
					return;
					
					}
					
					String sWelText=driver.findElement(By.cssSelector("#option-menu>li:nth-child(1)")).getText();
					if(sWelText.equals("welcome" + sUN))
					{
						System.out.println("welcome qaplanet displayed");
					}
					else
					{
						System.out.println("not displayed");
						
					}
					String[] Arr=sWelText.split(" ");
					if(Arr[1].equals(sUN))
					{
						System.out.println(sUN+" displayed");
					}
					WebElement pim=driver.findElement(By.linkText("PIM"));
					Act.moveToElement(pim).perform();
					WebElement addemploye=driver.findElement(By.linkText("Add Employee"));
					addemploye.click();
					driver.switchTo().frame("rightMenu");
					WebElement pimaddemploye=driver.findElement(By.xpath("//div[@class='mainHeading']/h2"));
					if(pimaddemploye.getText().equals("PIM : Add Employee"))
					{
						System.out.println("display add employe text");
					}
					else
					{
						System.out.println("failed");
				
					}
					String code=driver.findElement(By.name("txtEmployeeId")).getAttribute("value");
					WebElement save=driver.findElement(By.className("savebutton"));
					save.click();
					Alert A=driver.switchTo().alert();
					if(A.getText().equals("Last Name Empty!")) {
						System.out.println("Last Name Empty!");
						A.accept();
						
					}
					WebElement lastname=driver.findElement(By.name("txtEmpLastName"));
					
					lastname.sendKeys("lakshmi");
					save.click();
					
					
					Alert B=driver.switchTo().alert();
					if(B.getText().equals("First Name Empty!"))
					{
						System.out.println("First Name Empty!");
						B.accept();
					}
					
WebElement firstname=driver.findElement(By.name("txtEmpFirstName"));
firstname.sendKeys("k");
save.click();
//wait for Personal Details
if(wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@class='mainHeading']/h2"),"Personal Details")))
{
	System.out.println("Personal details and text displayed");
}
else
{
	System.out.println("Personal Details did not displayed");
}
//switch to parentframe
driver.switchTo().parentFrame();
// -------------------------------------------
//mouseover on pim
Act.moveToElement(pim).perform();
driver.findElement(By.linkText("Employee List")).click();
//switch to frame
driver.switchTo().frame("rightMenu");
//verify employe information
if(driver.findElement(By.xpath("//div[@class='mainHeading']/h2")).getText().equals("Employee Information"))
{
	System.out.println("employe information displayed");
}
else
{
	System.out.println("Failed to display Employee Information text");
}
//get row count
int rc=driver.findElements(By.xpath("//table/tbody/tr")).size();
for(int i=1;i<=rc;i++)
{
	String allcode=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[2]")).getText();
	WebElement allname=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]/a"));
	if(allcode.equals(code)&& allname.getText().equals("k lakshmi"))
	{
		System.out.println("successfully added");
		System.out.println(allcode+", "+allname.getText()+" displayed at: "+i);
		allname.click();
		break;
	}
	
}
//edit employ details
driver.findElement(By.name("EditMain")).click();
WebElement firstname1=driver.findElement(By.name("txtEmpFirstName"));
WebElement lastname1=driver.findElement(By.name("txtEmpLastName"));
firstname1.clear();
firstname1.sendKeys("ammu");
lastname1.clear();
lastname1.sendKeys("konakalla");
WebElement save1=driver.findElement(By.className("savebutton"));
save1.click();
Thread.sleep(2000);

//switch to parentframe
driver.switchTo().parentFrame();
//mouse overon pim
Act.moveToElement(driver.findElement(By.linkText("PIM"))).perform();
driver.findElement(By.linkText("Employee List")).click();
//switch to frame
driver.switchTo().frame("rightMenu");
//verify employ information
if(driver.findElement(By.xpath("//div[@class='mainHeading']/h2")).getText().equals("Employee Information"))
{
	System.out.println("employe information displayed");
}
else
{
	System.out.println("Failed to display Employee Information text");
}

for(int i=1;i<=rc;i++)
{
	String allcode=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[2]")).getText();
	WebElement allname=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]/a"));
	if(allcode.equals(code)&& allname.getText().equals("ammu konakalla"))
	{
		System.out.println("successfully edited");
		System.out.println(allcode+", "+allname.getText()+" displayed at: "+i);
		
		break;
	}
}
//delete	
WebElement delete=driver.findElement(By.xpath("//input[@value='Delete']"));
delete.click();
Thread.sleep(1000);
//for alert
Alert b=driver.switchTo().alert();
if(b.getText().equals("Select at least one record to delete")) {
	System.out.println("Select at least one record to delete");
	b.accept();
	
}	driver.findElement(By.xpath("//td[contains(text(),'"+code+"')]/preceding-sibling::td/input")).click();
	delete.click();
	//verify successfully deleted text
	WebElement text=driver.findElement(By.xpath("//span[contains( text(),'Successfully Deleted')]"));
	if(text.isDisplayed()&&text.getText().equals("Successfully Deleted"))
	{
		System.out.println("Successfully Deleted");
	}

	//way2 for verify deletion
	Select s=new Select(driver.findElement(By.name("loc_code")));
	s.selectByIndex(1);
driver.findElement(By.name("loc_name")).sendKeys(code);
driver.findElement(By.xpath("//input[@value='Search']")).click();
Thread.sleep(1000);
//norecords to display
WebElement norecords=driver.findElement(By.className("noresultsbar"));
if(norecords.isDisplayed()&& norecords.equals("No Records to Display"))
{
	System.out.println("No Records to Display");
}
//change password
WebElement changepassword=driver.findElement(By.linkText("Change Password"));
if(changepassword.isDisplayed())
{
	System.out.println("change password is displayed");
}
//logout
driver.switchTo().parentFrame();
WebElement logout=driver.findElement(By.linkText("Logout"));
logout.click();




					
					
					
					
}
	}
}
