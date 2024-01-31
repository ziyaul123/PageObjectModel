package driverFactory;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Config.AppUtil;
import applicationLayer.CustomerPage;
import utilities.ExcelFileUtil;

public class AppTest extends AppUtil {
   String Inputpath ="./FileInput/Customers.xlsx";
   String Outputpath ="./FileOutput/POMResults.xlsx";
   ExtentReports report;
   ExtentTest logger;
   String sheetName="CustomerData";
@Test
   public void startTest() throws Throwable
{


	report = new ExtentReports("./target/ExtentReports/Customers.html");
	//create obejct for excel file util class
		ExcelFileUtil xl = new ExcelFileUtil(Inputpath);
		int rc = xl.rowCount(sheetName);
		Reporter.log("No of rows are::"+rc,true);
		for(int i=1;i<=rc;i++)
		{
			logger = report.startTest("Customer Validation");
			//read all cells from CustomerData sheet
			String CustomerName = xl.getCellData(sheetName, i, 0);
			String Adress = xl.getCellData(sheetName, i, 1);
			String City = xl.getCellData(sheetName, i, 2);
			String Country = xl.getCellData(sheetName, i, 3);
			String Contactperson = xl.getCellData(sheetName, i, 4);
			String PhoneNumber = xl.getCellData(sheetName, i, 5);
			String Emailid = xl.getCellData(sheetName, i, 6);
			String MobileNumber = xl.getCellData(sheetName, i, 7);
			String Notes = xl.getCellData(sheetName, i, 8);
			logger.log(LogStatus.INFO,CustomerName+"   "+Adress+"    "+City+"   "+Country+"   "+Contactperson+"   "+PhoneNumber+"   "+Emailid+"  "+MobileNumber+"   "+Notes);
			CustomerPage cus = PageFactory.initElements(driver, CustomerPage.class);
			boolean res = cus.add_Customer(CustomerName, Adress, City, Country, Contactperson, PhoneNumber, Emailid, MobileNumber, Notes);
			if(res) 
			{
				//if res is true write as pass into status cell
				xl.setCellData(sheetName, i, 9, "Pass", Outputpath);
				logger.log(LogStatus.PASS, "Add Customer Success");
			}
			else
			{
				//if res is false write as Fail into status cell
				xl.setCellData(sheetName, i, 9, "Fail", Outputpath);
				logger.log(LogStatus.FAIL, "Add Customer Fail");
			}
			report.endTest(logger);
			report.flush();
		}
	}

}


