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

import com.gargoylesoftware.htmlunit.AlertHandler;

public class Addlocationexmp {

	public static void main(String[] args)throws Exception {
		
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
//company info
WebElement compnyInfo=driver.findElement(By.linkText("Company Info"));
Act.moveToElement(compnyInfo).perform();
WebElement locations=driver.findElement(By.linkText("Locations"));
locations.click();
//switch to frame
driver.switchTo().frame("rightMenu");
//company info locations
WebElement companyinfolocations=driver.findElement(By.xpath("//div[@class='mainHeading']/h2"));
WebElement select=driver.findElement(By.name("loc_code"));
WebElement searchfor=driver.findElement(By.name("loc_name"));
WebElement search=driver.findElement(By.xpath("//input[@value='Search']"));
WebElement reset=driver.findElement(By.xpath("//input[@value='Reset']"));
WebElement add=driver.findElement(By.xpath("//input[@value='Add']"));
WebElement delete=driver.findElement(By.xpath("//input[@value='Delete']"));
if(companyinfolocations.isDisplayed()&&(select.isDisplayed()&&(searchfor.isDisplayed()&&(search.isDisplayed()&&(reset.isDisplayed()&&(add.isDisplayed()&&(delete.isDisplayed())))))));
{
	System.out.println("display all fields");
}

//click on add
add.click();
WebElement companyinfolocation=driver.findElement(By.xpath("//div[@class='mainHeading']/h2"));
WebElement name=driver.findElement(By.xpath("//input[@name='txtLocDescription']"));
WebElement country=driver.findElement(By.name("cmbCountry"));
WebElement address=driver.findElement(By.name("txtAddress"));
WebElement zipcode=driver.findElement(By.xpath("//input[@name='txtZIP']"));
WebElement save=driver.findElement(By.xpath("//input[@class='savebutton']"));
if(companyinfolocation.isDisplayed()&& (name.isDisplayed()&&(address.isDisplayed()&&(zipcode.isDisplayed()&&(save.isDisplayed())))));
{
	System.out.println("display all fields");
}
//click on save

save.click();
//alert
Alert A=driver.switchTo().alert();
System.out.println(A.getText());
if(A.getText().equals("Please correct the following\n\n\t- Location Name has to be specified\n\t- Country should be selected!\n\t- Address should be specified\n\t- Zip Code should be specified\n"));
{
	System.out.println("all fields should be entered");
	A.accept();
}
Timestamp ts=new Timestamp(System.currentTimeMillis());
String locname="lakshmi "+ts;
name.sendKeys(locname);
save.click();
//alert
Alert B=driver.switchTo().alert();
if(B.getText().equals("Please correct the following\n\n\t- Country should be selected!\n\t- Address should be specified\n\t- Zip Code should be specified\n"))
{

System.out.println("all fields should be entered");
B.accept();
	}
//to select drop down
Select s=new Select(country);
s.selectByVisibleText("India");
//s.selectByValue("AO");
//s.selectByIndex(3);
//alert
save.click();
Alert C=driver.switchTo().alert();
if(C.getText().equals("Please correct the following\n\n\t- Address should be specified\n\t- Zip Code should be specified\n"))
	C.accept();
{
System.out.println("remaning fields display");
}
address.sendKeys("1415/p sheshdri towers ");
save.click();
Alert D=driver.switchTo().alert();
if(D.getText().equals("Please correct the following\n\n\t- Zip Code should be specified\n"))
{
	System.out.println();
	D.accept();
}else 
{
	System.out.println("alert failed");
	}
zipcode.sendKeys("500703");
Thread.sleep(2000);
save.click();
//System.out.println("success");
Thread.sleep(2000);
if(wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@class='messagebar']"), "Successfully Added")))
		{
System.out.println("successfully added");
		}else
		{
			System.out.println("successfully not added");
					}
//edit location
//verify company info location
WebElement text=driver.findElement(By.xpath("//div[@class='mainHeading']/h2"));
if(text.getText().equals("Company Info : Locations"))
{
	System.out.println("company is displayed");
}
//locid
String code=driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr/td/a[contains(text(),'"+locname+"')]/ancestor::td/preceding-sibling::td[1]/a")).getText();
System.out.println(code);
//click on name
List<WebElement> name1=driver.findElements(By.xpath("//table/tbody/tr/td/a"));
Iterator<WebElement>it=name1.iterator();
while(it.hasNext()) {
	//System.out.println("..........");
	WebElement we=it.next();
	if(we.getText().equals(locname)) {
		System.out.println(locname);
		we.click();
		break;
	}
	
}

//WebElement mylocation=driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr/td/a[contains(text(),'lakshmi')]"));

WebElement editlocation=driver.findElement(By.id("editBtn"));
editlocation.click();
WebElement name11=driver.findElement(By.xpath("//input[@name='txtLocDescription']"));
WebElement country1=driver.findElement(By.name("cmbCountry"));
WebElement address1=driver.findElement(By.name("txtAddress"));
WebElement zipcode1=driver.findElement(By.xpath("//input[@name='txtZIP']"));
name11.clear();
name11.sendKeys("lakki");
Select sel=new Select(country1);
sel.selectByValue("AF");
address1.clear();
address1.sendKeys("kukatpally");
zipcode1.clear();
zipcode1.sendKeys("500072");
driver.findElement(By.className("savebutton")).click();
//successfully updated;
Thread.sleep(2000);
if(wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@class='messagebar']"), "Successfully Updated")))
		{
System.out.println("successfully updated");
		}else
		{
			System.out.println("successfully not updated");
					}
//verify for text
String updatedname=driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr/td/a[contains(text(),'"+code+"')]/ancestor::td/following-sibling::td[1]/a")).getText();

	System.out.println(updatedname);
	



//delete location
WebElement delete1=driver.findElement(By.xpath("//input[@value='Delete']"));
delete1.click();
//handle alert
Alert e=driver.switchTo().alert();
if(e.getText().equals("Select at least one record to delete"))
	e.accept();
WebElement checkbox=driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr/td/a[contains(text(),'"+code+"')]/ancestor::td/preceding-sibling::td[1]/input"));
checkbox.click();
delete1.click();
Alert f=driver.switchTo().alert();
if(f.getText().equals("Deletion might affect Company Hierarchy. If the Location has associations deletion may fail. Do you want to delete ?"))
{
	System.out.println("successfully deleted");
	f.accept();
	
}
//verify text
if(wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//span[@class='success']"), "Successfully Deleted")));
{
System.out.println("Successfully Deleted");

}
	
{
		System.out.println("not deleted");
		}
//delete multiple locations
WebElement searchby=driver.findElement(By.name("loc_code"));
Select id=new Select(searchby);
id.selectByVisibleText("ID");
WebElement searchfor1=driver.findElement(By.xpath("//input[@name='loc_name']"));
searchfor1.sendKeys("LOC55");
WebElement search1=driver.findElement(By.xpath("//input[@value='Search']"));
search1.click();
//for select checkbox
WebElement checkbox1=driver.findElement(By.xpath("//table/thead/tr/td[1]/input"));
checkbox1.click();
WebElement delete2=driver.findElement(By.xpath("//input[@value='Delete']"));
delete2.click();
Alert g=driver.switchTo().alert();
if(g.getText().equals("Deletion might affect Company Hierarchy. If the Location has associations deletion may fail. Do you want to delete ?"));
{
	System.out.println("successfully deleted");
}
	{
		
	}
	}
	}








