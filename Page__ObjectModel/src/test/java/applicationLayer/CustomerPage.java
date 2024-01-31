package applicationLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class CustomerPage 
{
	WebDriver driver;
	public CustomerPage(WebDriver driver) 
	{
		this.driver=driver;
		}
	// define repository with using page factory
			@FindBy(xpath = "(//a[starts-with(text(),'Customers')])[2]")
			WebElement ObjCustomer;
			@FindBy(xpath = "(//span[@data-phrase='AddLink'])[1]")
			WebElement ObjAddIcon;
			@FindBy(xpath = "//input[@id='x_Customer_Number']")
			WebElement ObjCustomerNumber;
			@FindBy(xpath = "//input[@id='x_Customer_Name']")
			WebElement ObjCustomerName;
			@FindBy(xpath = "//textarea[@id='x_Address']")
			WebElement ObjAdress;
			@FindBy(xpath = "//input[@id='x_City']")
			WebElement ObjCity;
			@FindBy(xpath = "//input[@id='x_Country']")
			WebElement ObjCountry;
			@FindBy(xpath = "//input[@id='x_Contact_Person']")
			WebElement ObjContactperson;
			@FindBy(xpath = "//input[@id='x_Phone_Number']")
			WebElement ObjPhoneNumber;
			@FindBy(xpath = "//input[@id='x__Email']")
			WebElement ObjEmailid;
			@FindBy(xpath = "//input[@id='x_Mobile_Number']")
			WebElement ObjMobileNumber;
			@FindBy(xpath = "//input[@id='x_Notes']")
			WebElement ObjNotes;
			@FindBy(xpath = "//button[@id='btnAction']")
			WebElement ObjAddbtn;
			@FindBy(xpath = "//button[normalize-space()='OK!']")
			WebElement ObjConfirmok;
			@FindBy(xpath = "(//button[starts-with(text(),'OK')])[6]")
			WebElement ObjAlertok;
			@FindBy(xpath = "//span[@data-caption='Search']")
			WebElement ObjSearchpanel;
			@FindBy(xpath = "//input[@id='psearch']")
			WebElement ObjSearchtextbox;
			@FindBy(xpath = "//button[@id='btnsubmit']")
			WebElement ObjSearchbutton;
			@FindBy(xpath = "//table[@class='table ewTable']/tbody/tr[1]/td[5]/div/span/span")
			WebElement ObjWebtable;
			//methed for add customer by ussing this if u want to ferforn without using this then u can....
	public boolean add_Customer(String CustomerName,String Adress,String city,String Country,String ContactName,String PhoneNumber,String Emailid,String MobileNumber,String Notes) throws Throwable	
	{
		this.ObjCustomer.click();
		this.ObjAddIcon.click();
		String Exp_Num = this.ObjCustomerNumber.getAttribute("value");
		this.ObjCustomerName.sendKeys(CustomerName);
		this.ObjAdress.sendKeys(Adress);
		this.ObjCity.sendKeys(city);
		this.ObjCountry.sendKeys(Country);
		this.ObjContactperson.sendKeys(ContactName);
		this.ObjPhoneNumber.sendKeys(PhoneNumber);
		this.ObjEmailid.sendKeys(Emailid);
		this.ObjMobileNumber.sendKeys(MobileNumber);
		this.ObjNotes.sendKeys(Notes);
		this.ObjAddbtn.click();
		Thread.sleep(2000);
		this.ObjConfirmok.click();
		Thread.sleep(2000);
		this.ObjAlertok.click();
		if(!this.ObjSearchtextbox.isDisplayed())
			this.ObjSearchpanel.click();
		    this.ObjSearchtextbox.clear();
		   this.ObjSearchtextbox.sendKeys(Exp_Num);
		    this.ObjSearchbutton.click();
		    Thread.sleep(2000);
		    String Act_Num = this.ObjWebtable.getText();
		    if(Act_Num.equals(Exp_Num)) 
		    {
		    	Reporter.log("Customer Addad Success::"+Exp_Num+"   "+Act_Num,true);
		    	return true;
		    }
		    else 
		    {
		    	Reporter.log("Customer Addad Fail::"+Exp_Num+"   "+Act_Num,false);
		    	return false;
		    	
		    }
		
		
	}	
			
			
	

}
