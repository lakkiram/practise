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

public class Addjobtitle {

	public static void main(String[] args)throws Exception {
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
Thread.sleep(1000);
List<WebElement> li=driver.findElements(By.xpath("//li[@id='admin']/ul/li/a/span"));
Iterator<WebElement> ad=li.iterator();
while(ad.hasNext())
{
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
		}
	}
}
		// select jobtitle
		WebElement job=driver.findElement(By.linkText("Job"));
		Act.moveToElement(job).perform();
		WebElement jobtitle=driver.findElement(By.linkText("Job Titles"));
		jobtitle.click();
		//verify jobtitle
		driver.switchTo().frame("rightMenu");
		WebElement jobti=driver.findElement(By.xpath("//div[@class='mainHeading']/h2"));
		
		if(jobti.getText().equals("Job : Job Title"))
		{
			System.out.println("print jobtitle page");
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
	if(driver.findElement(By.xpath("//div[@class='mainHeading']/h2")).getText().equals("Job : Job Title"))
	
		System.out.println("display jobtitle main page");
		
	
//with out entering any fields click on save
WebElement save=driver.findElement(By.xpath("//input[@value='Save']"));
save.click();
//clickelert
Alert A=driver.switchTo().alert();
System.out.println(A.getText());
if(A.getText().equals("Job Title Name should be specified"))
	{System.out.println("handle");
A.accept();
	}
WebElement jobname=driver.findElement(By.name("txtJobTitleName"));
WebElement jobdiscription=driver.findElement(By.name("txtJobTitleDesc"));
jobname.sendKeys("manual tester");
save.click();
Alert B=driver.switchTo().alert();
System.out.println(B.getText());
if(B.getText().equals("Job Description should be specified"))
	{System.out.println("handle");
B.accept();
	}
jobdiscription.sendKeys("manual");
save.click();
//click on edit then display  verify add employe status,edit employe status
WebElement edit=driver.findElement(By.xpath("//input[@class='editbutton']"));
edit.click();
//verify add employment status
//edit employment status
WebElement addemploymentstatus=driver.findElement(By.xpath("//input[@value='Add Employment Status']"));
WebElement editemploymentstatus=driver.findElement(By.xpath("//input[@value='Edit Employment Status']"));
addemploymentstatus.click();
Thread.sleep(2000);
//verify employe status must be displayed
WebElement employestatus=driver.findElement(By.xpath("//input[@name='txtEmpStatDesc']"));
employestatus.sendKeys("lakshmi1");
WebElement save1=driver.findElement(By.xpath("//div[@id='layerEmpStat']/input[@value='Save']"));
save1.click();
WebElement editpaygrade=driver.findElement(By.name("cmbUnAssEmploymentStatus"));
Select S=new Select(editpaygrade);
S.selectByVisibleText("lakshmi1");
editemploymentstatus.click();
Thread.sleep(2000);
//
employestatus.clear();
employestatus.sendKeys("lakki1");
save1.click();
String code=driver.findElement(By.className("formValue")).getText();
System.out.println(code);
driver.findElement(By.className("savebutton")).click();
//alert
Alert c=driver.switchTo().alert();
System.out.println(c.getText());
c.accept();
//edit job title
WebElement searchby1=driver.findElement(By.name("loc_code"));
WebElement searchfor1=driver.findElement(By.name("loc_name"));
WebElement search1=driver.findElement(By.xpath("//input[@value='Search']"));
Select s=new Select(searchby1);
s.selectByVisibleText("ID");
searchfor1.sendKeys(code);
search1.click();
WebElement jobtitlename=driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr/td[3]/a"));
if(jobtitlename.getText().equals("manual tester"))
jobtitlename.click();
WebElement edit1=driver.findElement(By.xpath("//input[@class='editbutton']"));
edit1.click();
WebElement jobname1=driver.findElement(By.name("txtJobTitleName"));
WebElement jobdiscription1=driver.findElement(By.name("txtJobTitleDesc"));
jobname1.clear();
jobname1.sendKeys("selenium");
jobdiscription1.clear();
jobdiscription1.sendKeys("automation");
WebElement save2=driver.findElement(By.id("editBtn"));
save2.click();
Thread.sleep(2000);
//verify job title  edit
if(wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//span[@class='success']"), "Successfully Updated")))
{
	System.out.println("Successfully Updated");
}
	else
	{
		System.out.println("not Successfully Updated");
	}
//delete job title
//select page4
WebElement page4=driver.findElement(By.linkText("4"));
page4.click();
Timestamp ts=new Timestamp(System.currentTimeMillis());
WebElement delete1=driver.findElement(By.xpath("//input[@value='Delete']"));
delete1.click();
//handle alert
Alert d=driver.switchTo().alert();
if(d.getText().equals("Select at least one record to delete"))
	d.accept();
driver.findElement(By.xpath("//table/tbody/tr/td[2]/a[contains(text(),'"+code+"')]/ancestor::td/preceding-sibling::td/input")).click();
delete1.click();
//handle alert
Alert e=driver.switchTo().alert();
if(e.getText().equals("Deletion may affect Pay Grade of Employees in PIM. Do you want to delete ?"));
e.accept();

//verify Successfully deletedpage
if(wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//span[@class='success']"), "Successfully Deleted")));
	System.out.println("Successfully Deleted");
	
	}
	

}

	
	

